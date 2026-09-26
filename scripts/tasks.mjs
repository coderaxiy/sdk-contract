#!/usr/bin/env node
// Task inbox tooling. See tasks/README.md.
//
//   node scripts/tasks.mjs list [--all]     open tasks (or every task)
//   node scripts/tasks.mjs check            validate every task's frontmatter
//   node scripts/tasks.mjs new <id> <to>    create tasks/<id>.md from the template

import { existsSync, readdirSync, readFileSync, writeFileSync } from 'node:fs';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

const TASKS_DIR = join(dirname(fileURLToPath(import.meta.url)), '..', 'tasks');
const TEMPLATE = '_TEMPLATE.md';

const STATUSES = ['open', 'closed'];
const SIDES = ['backend', 'frontend', 'mobile'];
const PRIORITIES = ['low', 'normal', 'high'];
const REQUIRED = ['id', 'title', 'author', 'to', 'status', 'priority', 'area', 'created'];
const ID_RE = /^[a-z0-9]+(-[a-z0-9]+)*$/;
const DATE_RE = /^\d{4}-\d{2}-\d{2}$/;

function parseFrontmatter(text) {
  const match = text.match(/^---\n([\s\S]*?)\n---\n/);
  if (!match) return null;
  const fields = {};
  for (const line of match[1].split('\n')) {
    const m = line.match(/^([a-z_]+):\s*(.*?)\s*(#.*)?$/);
    if (m) fields[m[1]] = m[2];
  }
  return fields;
}

function loadTasks() {
  return readdirSync(TASKS_DIR)
    .filter((f) => f.endsWith('.md') && f !== TEMPLATE && f !== 'README.md')
    .sort()
    .map((file) => ({ file, fields: parseFrontmatter(readFileSync(join(TASKS_DIR, file), 'utf8')) }));
}

function validate({ file, fields }) {
  if (!fields) return ['missing frontmatter block'];
  const errors = [];
  for (const key of REQUIRED) if (!fields[key]) errors.push(`missing \`${key}\``);
  if (fields.id && fields.id !== file.replace(/\.md$/, '')) errors.push(`id \`${fields.id}\` doesn't match file name`);
  if (fields.id && !ID_RE.test(fields.id)) errors.push('id must be kebab-case');
  if (fields.status && !STATUSES.includes(fields.status)) errors.push(`status must be one of: ${STATUSES.join(', ')}`);
  if (fields.to && !SIDES.includes(fields.to)) errors.push(`to must be one of: ${SIDES.join(', ')}`);
  if (fields.priority && !PRIORITIES.includes(fields.priority)) errors.push(`priority must be one of: ${PRIORITIES.join(', ')}`);
  if (fields.created && !DATE_RE.test(fields.created)) errors.push('created must be YYYY-MM-DD');
  if (fields.status === 'closed' && !DATE_RE.test(fields.closed ?? '')) errors.push('closed tasks need a `closed:` date');
  if (fields.status === 'open' && fields.closed) errors.push('open tasks must not have a `closed:` date');
  if (fields.reply_to && !existsSync(join(TASKS_DIR, `${fields.reply_to}.md`))) errors.push(`reply_to \`${fields.reply_to}\` doesn't exist`);
  return errors;
}

function list(all) {
  const tasks = loadTasks().filter((t) => t.fields && (all || t.fields.status === 'open'));
  if (tasks.length === 0) {
    console.log(all ? 'No tasks.' : 'No open tasks.');
    return;
  }
  const rows = tasks.map(({ fields: f }) => [f.status, f.priority, `→ ${f.to}`, f.area, f.id, f.title]);
  const widths = [0, 1, 2, 3, 4].map((i) => Math.max(...rows.map((r) => r[i].length)));
  for (const row of rows) {
    console.log(row.map((cell, i) => (i < widths.length ? cell.padEnd(widths[i]) : cell)).join('  '));
  }
}

function check() {
  let failed = 0;
  for (const task of loadTasks()) {
    const errors = validate(task);
    if (errors.length) {
      failed++;
      console.error(`✗ tasks/${task.file}\n  - ${errors.join('\n  - ')}`);
    }
  }
  if (failed) {
    console.error(`\n${failed} task(s) invalid.`);
    process.exit(1);
  }
  console.log('✓ All tasks valid');
}

function create(id, to) {
  if (!id || !ID_RE.test(id)) fail('Usage: npm run task:new -- <kebab-id> <backend|frontend|mobile>');
  if (!SIDES.includes(to)) fail(`<to> must be one of: ${SIDES.join(', ')}`);
  const target = join(TASKS_DIR, `${id}.md`);
  if (existsSync(target)) fail(`tasks/${id}.md already exists`);

  const today = new Date().toISOString().slice(0, 10);
  const body = readFileSync(join(TASKS_DIR, TEMPLATE), 'utf8')
    .replace(/^id: .*$/m, `id: ${id}`)
    .replace(/^to: .*$/m, `to: ${to}`)
    .replace(/^created: .*$/m, `created: ${today}`);
  writeFileSync(target, body);
  console.log(`✓ Created tasks/${id}.md — fill in title, author, area, and the body.`);
}

function fail(message) {
  console.error(`✗ ${message}`);
  process.exit(1);
}

const [command, ...args] = process.argv.slice(2);
switch (command) {
  case 'list':
    list(args.includes('--all'));
    break;
  case 'check':
    check();
    break;
  case 'new':
    create(args[0], args[1]);
    break;
  default:
    fail('Usage: node scripts/tasks.mjs <list [--all] | check | new <id> <to>>');
}
