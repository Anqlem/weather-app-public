# weather-app backend

Spring Boot 3 (Java 21) backend for the weather-app React frontend. It proxies:

- `GET /api/weather/current?city={city}` → OpenWeatherMap current weather
- `GET /api/weather/forecast?city={city}` → OpenWeatherMap 5-day forecast
- `GET /api/places/autocomplete?input={input}` → Google Places Autocomplete (city predictions)

Responses are passed through as-is from the upstream APIs, so the frontend's existing
JSON parsing (`weather.main`, `weather.weather[0].icon`, `predictions[].description`, etc.)
needs no changes beyond pointing at this backend. The point of this service is to keep the
OpenWeatherMap and Google Maps API keys off the browser.

## Running locally

Requires JDK 21 and Maven (or an IDE that bundles both, e.g. IntelliJ IDEA).

Local dev secrets already live in `src/main/resources/application-local.yml` (gitignored,
active by default — carried over from the project's previous root `.env`), so you can just run:

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`, with CORS open to `http://localhost:3000` (the
React dev server).

## Configuring for other environments

Don't rely on `application-local.yml` outside local dev. Instead set real environment
variables (see `.env.example`):

- `OPENWEATHER_API_KEY`
- `GOOGLE_MAPS_API_KEY`
- `APP_CORS_ORIGINS` (comma-separated allowed origins)

and run with a non-`local` profile, e.g. `SPRING_PROFILES_ACTIVE=prod`.

## Docker

`backend/.dockerignore` excludes `application-local.yml` from the build context, so the
local dev keys never end up baked into the image. The Docker image expects
`OPENWEATHER_API_KEY` / `GOOGLE_MAPS_API_KEY` / `APP_CORS_ORIGINS` as real env vars and
runs with `SPRING_PROFILES_ACTIVE=prod` — see the root `docker-compose.yml` and
`deploy.sh`, which load these from `backend/.env` (gitignored, copy from `.env.example`).
