#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

OUT="sdk/mobile/swift"

if ! command -v java >/dev/null 2>&1; then
  echo "✗ Java/JDK is required to run openapi-generator-cli. Install JDK 11+ and re-run." >&2
  exit 1
fi

find "$OUT" -mindepth 1 ! -name '.gitkeep' -exec rm -rf {} + 2>/dev/null || true

# FastAPI's 422 schema is named ValidationError, which collides with the
# swift6 runtime's own ValidationError type.
echo "▶ Generating Swift client → $OUT"
npx openapi-generator-cli generate \
  --input-spec openapi/api.yaml \
  --generator-name swift6 \
  --output "$OUT" \
  --model-name-mappings ValidationError=APIValidationError \
  --additional-properties=\
projectName=EmarketSellerSDK,\
responseAs=AsyncAwait

# openapi-generator-cli can exit 0 without writing anything (e.g. an interrupted
# first-run jar download) — don't report success on an empty SDK.
if [ -z "$(find "$OUT" -mindepth 1 ! -name '.gitkeep' -print -quit)" ]; then
  echo "✗ Nothing was generated in $OUT — re-run the command." >&2
  exit 1
fi

echo "✓ Swift SDK written to $OUT"
