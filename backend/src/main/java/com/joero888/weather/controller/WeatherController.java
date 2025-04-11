package com.joero888.weather.controller;

import com.joero888.weather.model.WeatherResponse;
import com.joero888.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired; // Importing the WeatherService class to handle API calls
import org.springframework.web.bind.annotation.*; // Importing RestController and RequestMapping annotations to define controller and its endpoints

@CrossOrigin(origins = "http://localhost:3000")
// allows cross-origin requests from the specified origin, useful for development when frontend and backend are on different ports.
// This is a security feature to prevent unauthorized access to your API from other domains.

@RestController // indicates that this class is a REST controller, tells Spring this class handles HTTP requests and returns JSON.
@RequestMapping("/weather") // maps HTTP requests to the specified URL path, all endpoints here will start with /weather.

public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping //handles GET requests like /weather?city=London
    public WeatherResponse getWeather(
        @RequestParam String city,
        @RequestParam(defaultValue = "imperial") String unit
    ) {  // grabs the city query parameter from URL
        return weatherService.getWeather(city, unit);  // returns the result as JSON.
    }
}


