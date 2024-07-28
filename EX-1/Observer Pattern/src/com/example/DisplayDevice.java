package com.example;
public class DisplayDevice implements Observer {
    private String deviceName;

    public DisplayDevice(String deviceName) {
        this.deviceName = deviceName;
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(deviceName + " updated with weather data: Temperature=" + temperature + " Humidity=" + humidity + " Pressure=" + pressure);
    }
}
