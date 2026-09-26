#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

OUT="sdk/mobile/kotlin"

if ! command -v java >/dev/null 2>&1; then
  echo "✗ Java/JDK is required to run openapi-generator-cli. Install JDK 11+ and re-run." >&2
  exit 1
fi

# Wipe previous generation (keeps .gitkeep)
find "$OUT" -mindepth 1 ! -name '.gitkeep' -exec rm -rf {} + 2>/dev/null || true

echo "▶ Generating Kotlin client → $OUT"
npx openapi-generator-cli generate \
  --input-spec openapi/api.yaml \
  --generator-name kotlin \
  --output "$OUT" \
  --additional-properties=\
serializationLibrary=kotlinx_serialization,\
library=jvm-retrofit2,\
useCoroutines=true,\
packageName=com.emarketseller.sdk,\
apiPackage=com.emarketseller.sdk.api,\
modelPackage=com.emarketseller.sdk.model,\
sourceFolder=src/main/kotlin,\
artifactId=emarketseller-sdk,\
groupId=com.emarketseller,\
artifactVersion=0.1.0

# openapi-generator-cli can exit 0 without writing anything (e.g. an interrupted
# first-run jar download) — don't report success on an empty SDK.
if [ -z "$(find "$OUT" -mindepth 1 ! -name '.gitkeep' -print -quit)" ]; then
  echo "✗ Nothing was generated in $OUT — re-run the command." >&2
  exit 1
fi

# The generator writes the Gradle wrapper without the executable bit.
chmod +x "$OUT/gradlew"

echo "✓ Kotlin SDK written to $OUT"
