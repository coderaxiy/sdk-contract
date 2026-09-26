#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

echo "▶ Validating openapi/api.yaml"
npx redocly lint openapi/api.yaml --config redocly.yaml

echo "✓ Contract is valid"
