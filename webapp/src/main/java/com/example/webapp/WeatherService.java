package com.example.webapp;

import com.example.webapp.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.city}")
    private String city;

    public Double getTemperature() {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        return weatherResponse != null ? weatherResponse.getMain().getTemp() : null;
    }

    public String getCity() {
        return city;
    }
}
