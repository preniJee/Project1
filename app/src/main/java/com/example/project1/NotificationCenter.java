package com.example.project1;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class NotificationCenter extends Observable {
    ArrayList<Observer> observers;
    public NotificationCenter(){
        observers = new ArrayList<>();
    }
    //@Override
    public void data_loaded(int[] message){
        System.out.println(message[3]);
        System.out.println("in data loaded");
        for(Observer element:observers)
            element.update(this, message);

    }
    //@Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    //@Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }


}
