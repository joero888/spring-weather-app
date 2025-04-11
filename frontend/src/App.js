import React, { useState } from 'react';

function App() {
  const [city, setCity] = useState('');
  const [unit, setUnit] = useState('imperial'); 
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState('');

  const fetchWeather = async () => {
    if (!city) return;

    try {
      const response = await fetch(`http://localhost:8080/weather?city=${encodeURIComponent(city)}&unit=${unit}`);
      if (!response.ok) throw new Error('City not found or backend error');

      const data = await response.json();
      setWeather(data);
      setError('');
    } catch (err) {
      setError(err.message);
      setWeather(null);
    }
  };

  const unitSymbol = unit === 'imperial' ? '°F' : '°C'; // change to Celsius if needed
  const windUnit = unit === 'imperial' ? 'mph' : 'm/s';

  
  return (
    <div style={{ padding: '2rem', fontFamily: 'Arial' }}>
      <h1>🌤️ Weather App</h1>

      <input
        type="text"
        value={city}
        onChange={(e) => setCity(e.target.value)}
        placeholder="Enter a city"
        style={{ padding: '0.5rem', width: '200px' }}
      />
      <button onClick={fetchWeather} style={{ marginLeft: '0.5rem', padding: '0.5rem' }}>
        Get Weather
      </button>

      <div style={{ marginTop: '1rem' }}> 
        <label>
          <input
            type="radio"
            name="unit"
            value="imperial"
            checked={unit === 'imperial'}
            onChange={(e) => setUnit(e.target.value)}
          />
          °F
        </label>
        <label style={{ marginLeft: '1rem' }}>
          <input
            type="radio"
            name="unit"
            value="metric"
            checked={unit === 'metric'}
            onChange={(e) => setUnit(e.target.value)}
          />
          °C
        </label>
      </div>

      {error && <p style={{ color: 'red' }}>{error}</p>}

      {weather && (
        <div style={{ marginTop: '1rem' }}>
          <h2>{weather.name}</h2>
          <p>🌡️ Temp: {weather.main.temp}{unitSymbol}</p>
          <p>🥵 Feels Like: {weather.main.feels_like}{unitSymbol}</p>
          <p>💧 Humidity: {weather.main.humidity}%</p>
          <p>💨 Wind: {weather.wind.speed}{windUnit}</p>
          <p>☁️ {weather.weather[0].description}</p>
        </div>
      )}
    </div>
  );
}

export default App;
