import React, {useState} from 'react';
import './index.css';

function App() {

    const [weather, setWeather] = useState(null);
    const [city, setCity] = useState('');

    const fetchWeather = () => {
        fetch(`http://localhost:8080/weather?city=${city}`)
            .then(response => response.json())
            .then(data => setWeather(data))
            .catch(error => console.error("Error fetching weather data: ", error));
    }

    return (
        <div>
            <h1>Weather API</h1>
            <input type="text"
                   placeholder={"Enter city name"}
                   value={city}
                   onChange={e => setCity(e.target.value)}
            />
            <button onClick={fetchWeather}>Fetch Weather</button>

            {weather && (
                <div>
                    <h2>Weather in {city}</h2>
                    <p>Date: {weather.data[0].ob_time}</p>
                    <p>Temperature: {weather.data[0].temp}°C</p>
                    <p>Details: {weather.data[0].weather.description}</p>
                    <p>Clouds: {weather.data[0].clouds}%</p>
                    <p>Wind: {weather.data[0].wind_spd}m/s</p>
                    <img src={`https://www.weatherbit.io/static/img/icons/${weather.data[0].weather.icon}.png`}
                         alt="weather icon"/>
                </div>
            )}
        </div>

    );
}

export default App;
