#!/usr/bin/env bash
# One-command deploy on a Linux server with Docker. Run from the repo folder: ./deploy.sh
set -euo pipefail
cd "$(dirname "$0")"

command -v docker >/dev/null || { echo "Docker is not installed: https://docs.docker.com/engine/install/"; exit 1; }
docker compose version >/dev/null 2>&1 || { echo "Docker Compose plugin missing (apt install docker-compose-plugin)"; exit 1; }

if [ ! -f backend/.env ]; then
  cp backend/.env.example backend/.env
  chmod 600 backend/.env
  echo "Created backend/.env from the template."
  echo "Fill in OPENWEATHER_API_KEY and GOOGLE_MAPS_API_KEY (nano backend/.env), then run ./deploy.sh again."
  exit 0
fi

env_get() { grep -E "^$1=" .env 2>/dev/null | tail -1 | cut -d= -f2- || true; }

docker compose up -d --build

echo "Waiting for the backend..."
for _ in $(seq 1 30); do
  if docker compose exec -T backend wget -q -O- "http://localhost:8080/api/weather/current?city=London" >/dev/null 2>&1; then
    break
  fi
  sleep 2
done

docker compose ps
echo "Up. UI: http://$(env_get APP_BIND | sed 's/^$/127.0.0.1/'):$(env_get FRONTEND_PORT | sed 's/^$/3000/')"
