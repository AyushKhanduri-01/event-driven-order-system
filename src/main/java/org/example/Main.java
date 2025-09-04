package org.example;

import org.example.event.EventRegistryInitializer;
import org.example.event.*;
import org.example.observer.ObserverManager;
import org.example.parser.EventParser;
import org.example.event.BaseEvent;
import org.example.observer.AlertObserver;
import org.example.observer.LoggerObserver;
import org.example.processor.EventProcessor;
import org.example.processor.HandlerRegistryInitializer;

import java.io.*;

/**
 * Main class for running the event-driven order processing system.
 *
 * Responsibilities:
 * 1. Initialize registries for events and handlers.
 * 2. Set up observers to receive notifications.
 * 3. Read event data from a file and process each event.
 */
public class Main {
    public static void initializeRegistries(){
        new HandlerRegistryInitializer();
        new EventRegistryInitializer();
    }
    private static void initializeObserver() {
        ObserverManager observerManager = new ObserverManager();
        observerManager.addObserver(new LoggerObserver());
        observerManager.addObserver(new AlertObserver());
    }
    public static void main(String[] args) {
        initializeRegistries();
        initializeObserver();
        // Create the central EventProcessor
        EventProcessor eventProcessor = new EventProcessor();
        // Read events from a file and process them
       try(InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("events.txt")){
           if (inputStream == null) {
               System.out.println("File not found in resources!");
               return;
           }
           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           String line;
           while((line = reader.readLine()) != null){
               BaseEvent event = EventParser.parse(line);
               if(event != null){
                   // Process the event using EventProcessor
                   eventProcessor.processEvent(event);
               }
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (Exception e){
           e.printStackTrace();
       }
    }


}