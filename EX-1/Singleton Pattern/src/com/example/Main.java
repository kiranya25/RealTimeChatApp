package com.example;
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Another log message");

        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger));
    }
}
