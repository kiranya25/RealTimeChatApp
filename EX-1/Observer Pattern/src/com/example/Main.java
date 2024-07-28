package com.example;
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        DisplayDevice phone = new DisplayDevice("Phone");
        DisplayDevice tablet = new DisplayDevice("Tablet");
        DisplayDevice computer = new DisplayDevice("Computer");

        weatherData.addObserver(phone);
        weatherData.addObserver(tablet);
        weatherData.addObserver(computer);

        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
    }
}