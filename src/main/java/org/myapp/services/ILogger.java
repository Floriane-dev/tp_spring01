package main.java.org.myapp.services;

public interface ILogger {
    default void log(String message) {};

}
