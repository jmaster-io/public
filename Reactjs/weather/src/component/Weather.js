import React, { useState } from 'react';

const axios = require('axios');
const API_KEY = "220b162ef6574c97ac432326212612";
const BASE_URL = "http://api.weatherapi.com/v1";
export default function Weather() {
    let [weather, setWeather] = useState();
    const [address, setAddress] = useState();
    async function getWeather() {
        try {
            const response = await axios.get(`${BASE_URL}/current.json?key=${API_KEY}&q=${address}`);
            console.log(response?.data);
            setWeather(response?.data)
        } catch (error) {
            console.error(error);
        }
    }
    return (
        <div style={{ margin: 100 }} >
            <input placeholder="Nhập địa điểm" value={address} onChange={e => setAddress(e.target.value)} />
            <button onClick={getWeather} >Tra cứu</button>
            {weather && <ul>
                <li><label>Thời tiết tại</label> :{weather?.location?.name} - {weather?.location?.country} </li>
                <li><label>Nhiệt độ ( độ C )</label> :{weather?.current?.temp_c} </li>
                <li><label>Nhiệt độ ( độ F )</label> :{weather?.current?.temp_f} </li>
                <li><a href="https://www.weatherapi.com/" title="Free Weather API">
                    <img src={`${weather?.current?.condition?.icon}`} alt="Weather data by WeatherAPI.com" border="0" />
                </a></li>
            </ul>}



        </div>
    )
}