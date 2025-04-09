package com.joero888.weather.controller;

import com.joero888.weather.model.WeatherResponse;
import com.joero888.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired; // Importing the WeatherService class to handle API calls
import org.springframework.web.bind.annotation.*; // Importing RestController and RequestMapping annotations to define controller and its endpoints

@RestController // indicates that this class is a REST controller, tells Spring this class handles HTTP requests and returns JSON.
@RequestMapping("/weather") // maps HTTP requests to the specified URL path, all endpoints here will start with /weather.

public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping //handles GET requests like /weather?city=London
    public WeatherResponse getWeather(@RequestParam String city) {  // grabs the city query parameter from the URL
        return weatherService.getWeather(city);  // returns the result as JSON.
    }
}


