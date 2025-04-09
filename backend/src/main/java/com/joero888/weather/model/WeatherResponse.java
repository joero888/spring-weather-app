package com.joero888.weather.model;  // This class represents the response from the OpenWeatherMap API

import java.util.List;  // import list to hold multiple weather conditions

public class WeatherResponse {  // main class to hold entire weather reponse from API
    private Main main;  // object to hold main object, temp. and other data, nested Main to store data
    private List<Weather> weather;  // stores array of weather conditions
    private String name;  // stores name of the city
    private Wind wind;  // stores wind object

    public Main getMain() {  // getter for main object
        return main;
    }

    public void setMain(Main main) {  // setter for main object
        this.main = main;
    }

    public List<Weather> getWeather() {  // getter for weather list
        return weather;
    }

    public void setWeather(List<Weather> weather) {  // setter for weather list
        this.weather = weather;
    }

    public String getName() {  // getter for city name
        return name;
    }

    public void setName(String name) {  // setter for city name
        this.name = name;
    }

    public Wind getWind() {
    return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public static class Main {      // nested class to hold main object
        private double temp;
        private double feels_like;
        private int humidity;
        
        public double getTemp() {  // getter for temperature
            return temp;
        }

        public void setTemp(double temp) {  // setter for temperature
            this.temp = temp;
        }

        public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public static class Weather {  // nested class to hold weather object
        private String description;

        public String getDescription() {  // getter for weather description
            return description;
        }

        public void setDescription(String description) {  // setter for weather description
            this.description = description;
        }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
}
}