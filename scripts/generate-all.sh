#!/usr/bin/env bash
set -euo pipefail

DIR="$(cd "$(dirname "$0")" && pwd)"

bash "$DIR/generate-ts.sh"
bash "$DIR/generate-kotlin.sh"
bash "$DIR/generate-swift.sh"

echo "✓ All SDKs regenerated"
