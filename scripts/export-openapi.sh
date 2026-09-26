#!/usr/bin/env bash
# Export the OpenAPI spec from the FastAPI backend into openapi/api.yaml.
# The backend is the source of truth — run this after every API change.
#
# BACKEND_DIR defaults to the parent directory (this repo lives inside the
# backend checkout). Override it if the contract is checked out elsewhere:
#   BACKEND_DIR=~/code/emarketseller npm run export
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
BACKEND_DIR="$(cd "${BACKEND_DIR:-$ROOT/..}" && pwd)"
OUT="$ROOT/openapi/api.yaml"

if [ ! -f "$BACKEND_DIR/app/main.py" ]; then
  echo "✗ No FastAPI app at $BACKEND_DIR/app/main.py — set BACKEND_DIR." >&2
  exit 1
fi

PYTHON="$BACKEND_DIR/venv/bin/python"
[ -x "$PYTHON" ] || PYTHON="python3"

echo "▶ Exporting OpenAPI from $BACKEND_DIR"
cd "$BACKEND_DIR"
"$PYTHON" - "$OUT" <<'PY'
import sys

import yaml

from app.main import app

spec = app.openapi()
# Paths already carry the /api/v1 prefix. SDK consumers override the base URL per environment.
spec.setdefault("servers", [{"url": "http://localhost:8000", "description": "Local dev"}])

with open(sys.argv[1], "w") as f:
    yaml.safe_dump(spec, f, sort_keys=False, allow_unicode=True, width=100)
PY

echo "✓ Spec written to openapi/api.yaml"
