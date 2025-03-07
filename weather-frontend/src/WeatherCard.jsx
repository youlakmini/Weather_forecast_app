import React, { useState } from "react";
import axios from "axios";
import "./WeatherCard.css";

const WeatherCard = () => {
  const [weatherData, setWeatherData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchWeatherData = async () => {
    setLoading(true);
    setError(null);

    try {
      const response = await axios.get("http://localhost:8080/weather/temperature");
      setWeatherData(response.data);
    } catch (err) {
      setError("Error fetching weather data");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="weather-container">
      <div className="thumbnail" onClick={fetchWeatherData}>
        <img src="/images/weather.webp" alt="Weather-thumbnail" className="thumbnail-img" />
      </div>
      {loading && <p>Loading...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {weatherData && (
        <div className="weather-info">
          {weatherData.message ? (
            <p>{weatherData.message}</p>
          ) : (
            <>
              <h3>Weather in {weatherData.city}</h3>
              <p>Temperature: {weatherData.temperature}°{weatherData.unit}</p>
            </>
          )}
        </div>
      )}
    </div>
  );
};

export default WeatherCard;
