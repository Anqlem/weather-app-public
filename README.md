# Weather App

A modern, responsive weather application that provides real-time weather information for
locations worldwide. The app features a clean, intuitive interface based on the TypeWeather
Figma design, backed by a Java/Spring Boot API that proxies OpenWeatherMap and Google Places —
so no API key is ever exposed to the browser.

## Features

- 🌍 **Location Search**: Intelligent location search powered by Google Places Autocomplete API
- ☀️ **Real-time Weather Data**: Current weather conditions and a 5-day forecast from OpenWeather API
- 🎨 **Modern UI**: Clean interface built with Material-UI components
- 📱 **Responsive Design**: Works seamlessly across desktop and mobile devices
- 🔍 **Smart Autocomplete**: Quick and accurate city search with Google Places integration
- 🔒 **Server-side API keys**: Both third-party keys live only on the backend, never in the client bundle

## Tech Stack

**Frontend**
- **React**: Frontend framework
- **Axios**: HTTP client for API requests
- **Material-UI (MUI)**: Component library for UI elements

**Backend**
- **Java 21 / Spring Boot 3**: REST API proxying OpenWeatherMap and Google Places
- **Maven**: Build tool

**Deployment**
- **Docker / Docker Compose**: builds both services; nginx serves the production frontend
  build and reverse-proxies `/api/*` to the backend internally

## Prerequisites

Running with Docker (recommended):
- Docker and Docker Compose

Running without Docker:
- Node.js (v18 or higher) and npm
- Java 21 and Maven
- A Google Places API key and an OpenWeather API key (only needed on the backend, see below)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/Anqlem/weather-app-public.git
cd weather-app-public
```

### Option A — Docker

```bash
cp backend/.env.example backend/.env   # fill in OPENWEATHER_API_KEY and GOOGLE_MAPS_API_KEY
./deploy.sh
```
or directly: `docker compose up -d --build`.

The frontend is published on `127.0.0.1:3000` by default. Set `APP_BIND=0.0.0.0` and/or
`FRONTEND_PORT=<port>` in a root `.env` to expose it on your LAN. Never port-forward it
straight to the internet without additional protection (rate limiting, auth, etc.).

### Option B — Running locally without Docker

```bash
npm install

# backend: set your keys, then start the API on :8080
cp backend/.env.example backend/.env   # fill in OPENWEATHER_API_KEY and GOOGLE_MAPS_API_KEY
cd backend && mvn spring-boot:run

# frontend: in a second terminal, from the project root
npm start   # starts on :3000, calls the backend at REACT_APP_BACKEND_URL (.env, defaults to :8080)
```

The app will open at [http://localhost:3000](http://localhost:3000)

See `backend/README.md` for more backend-specific details.

## Available Scripts

- `npm start` - Runs the frontend in development mode
- `npm test` - Launches the test runner
- `npm run build` - Builds the frontend for production

## Getting API Keys

These are only ever needed on the backend (`backend/.env`), never in the frontend.

### OpenWeather API
1. Visit [OpenWeather](https://openweathermap.org/api)
2. Sign up for a free account
3. Generate an API key from your account dashboard

### Google Places API
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select an existing one
3. Enable the Places API
4. Create credentials (API key)
5. Since this key is now called server-side, restrict it by **IP address** (not HTTP referrer)

## Design

This project implements the [TypeWeather Figma design](https://www.figma.com/community/file/1264768570663183670), providing a modern and user-friendly weather interface.

## License

This project is open source and available under the MIT License.

## Acknowledgments

- Weather data provided by [OpenWeather](https://openweathermap.org/)
- Location services by [Google Places API](https://developers.google.com/maps/documentation/places/web-service)
- UI design inspired by [TypeWeather Figma Community](https://www.figma.com/community)
