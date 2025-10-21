Weather App
A modern, responsive weather application built with React that provides real-time weather information for locations worldwide. The app features a clean, intuitive interface based on the TypeWeather Figma design.
Features

🌍 Location Search: Intelligent location search powered by Google Places Autocomplete API
☀️ Real-time Weather Data: Current weather conditions from OpenWeather API
🎨 Modern UI: Clean interface built with Material-UI components
📱 Responsive Design: Works seamlessly across desktop and mobile devices
🔍 Smart Autocomplete: Quick and accurate city search with Google Places integration

Tech Stack

React: Frontend framework
Axios: HTTP client for API requests
Material-UI (MUI): Component library for UI elements
Google Places Autocomplete API: Location search functionality
OpenWeather API: Weather data provider

Prerequisites
Before running this project, you'll need:

Node.js (v14 or higher)
npm or yarn
Google Places API key
OpenWeather API key

Installation

Clone the repository:

bashgit clone https://github.com/Anqlem/weather-app-public.git
cd weather-app-public

Install dependencies:

bashnpm install

Create a .env file in the root directory and add your API keys:

envREACT_APP_GOOGLE_API_KEY=your_google_api_key
REACT_APP_OPENWEATHER_API_KEY=your_openweather_api_key

Start the development server:

bashnpm start
The app will open at http://localhost:3000
Available Scripts

npm start - Runs the app in development mode
npm test - Launches the test runner
npm run build - Builds the app for production
npm run eject - Ejects from Create React App (one-way operation)

Getting API Keys
OpenWeather API

Visit OpenWeather
Sign up for a free account
Generate an API key from your account dashboard

Google Places API

Go to Google Cloud Console
Create a new project or select an existing one
Enable the Places API
Create credentials (API key)
Restrict the key to Places API for security

Design
This project implements the TypeWeather Figma design, providing a modern and user-friendly weather interface.
Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
License
This project is open source and available under the MIT License.
Acknowledgments

Weather data provided by OpenWeather
Location services by Google Places API
UI design inspired by TypeWeather Figma Community
