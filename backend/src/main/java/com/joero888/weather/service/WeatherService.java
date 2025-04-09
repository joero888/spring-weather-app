package com.joero888.weather.service;

import com.joero888.weather.model.WeatherResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        System.out.println("🔐 @Value API Key: " + apiKey);
        System.out.println("🌱 Environment API Key: " + env.getProperty("OPENWEATHERMAP_API_KEY"));
    }

    public WeatherResponse getWeather(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
