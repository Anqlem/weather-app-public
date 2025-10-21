# Weather App

A modern, responsive weather application built with React that provides real-time weather information for locations worldwide. The app features a clean, intuitive interface based on the TypeWeather Figma design.

Deployed app -  https://mikhail-weather-app.vercel.app/

## Features

- 🌍 **Location Search**: Intelligent location search powered by Google Places Autocomplete API
- ☀️ **Real-time Weather Data**: Current weather conditions from OpenWeather API
- 🎨 **Modern UI**: Clean interface built with Material-UI components
- 📱 **Responsive Design**: Works seamlessly across desktop and mobile devices
- 🔍 **Smart Autocomplete**: Quick and accurate city search with Google Places integration

## Tech Stack

- **React**: Frontend framework
- **Axios**: HTTP client for API requests
- **Material-UI (MUI)**: Component library for UI elements
- **Google Places Autocomplete API**: Location search functionality
- **OpenWeather API**: Weather data provider

## Prerequisites

Before running this project, you'll need:

- Node.js (v14 or higher)
- npm or yarn
- Google Places API key
- OpenWeather API key

## Installation

1. Clone the repository:
```bash
git clone https://github.com/Anqlem/weather-app-public.git
cd weather-app-public
```

2. Install dependencies:
```bash
npm install
```

3. Edit a `.env` file in the root directory and add your API keys:
```env
REACT_APP_GOOGLE_MAPS_API_KEY=your_google_api_key
REACT_APP_WEATHER_API_KEY=your_openweather_api_key
```

4. Start the development server:
```bash
npm start
```

The app will open at [http://localhost:3000](http://localhost:3000)

## Available Scripts

- `npm start` - Runs the app in development mode
- `npm test` - Launches the test runner
- `npm run build` - Builds the app for production
- `npm run eject` - Ejects from Create React App (one-way operation)

## Getting API Keys

### OpenWeather API
1. Visit [OpenWeather](https://openweathermap.org/api)
2. Sign up for a free account
3. Generate an API key from your account dashboard

### Google Places API
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select an existing one
3. Enable the Places API
4. Create credentials (API key)
5. Restrict the key to Places API for security

## Design

This project implements the [TypeWeather Figma design](https://www.figma.com/community/file/1264768570663183670), providing a modern and user-friendly weather interface.

## License

This project is open source and available under the MIT License.

## Acknowledgments

- Weather data provided by [OpenWeather](https://openweathermap.org/)
- Location services by [Google Places API](https://developers.google.com/maps/documentation/places/web-service)
- UI design inspired by [TypeWeather Figma Community](https://www.figma.com/community)
