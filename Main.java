package com.company;

import java.util.List;
import java.util.ArrayList;

interface Notifier{
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObserver(String notification);
}

interface Observer{
    public void update(String groupName, String message);
}

class Group implements Notifier{
    private String name;
    private List<Observer> observers = new ArrayList<>();
    Group(String name){
        this.name = name;
    }
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObserver(String notification){
        for(Observer observer : observers){
            observer.update(name, notification);
        }
    }
}

class User implements Observer{
    private String username;
    User(String username){
        this.username = username;
    }
    @Override
    public void update(String groupName, String notification){
        System.out.printf("Сообщение от группы %s для %s: \"%s\"\n",groupName,username,notification);
    }
}

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Linda");
        User user2 = new User("Alex");

        Group group1 = new Group("Шишки & Орешки");
        Group group2 = new Group("Интеллектуальные мемы");
        Group group3 = new Group("Новости Пенза");
        Group group4 = new Group("ПКИПТ (IT-Колледж)");
        Group group5 = new Group("IGM");
        Group group6 = new Group("Котятки");
        Group group7 = new Group("Тушканчики каждый день");

        group1.addObserver(user1);
        group2.addObserver(user1);
        group3.addObserver(user1);

        group4.addObserver(user2);
        group5.addObserver(user2);
        group6.addObserver(user2);
        group7.addObserver(user2);

        group1.notifyObserver("Большой сырный раф со скидкой 30%");
        group2.notifyObserver("Когда ты подписан на 100 пабликов, но всё равно проверяешь уведомления вручную");
        group3.notifyObserver("Град в Колышлейском районе");
        group4.notifyObserver("Награждение активистов колледжа");
        group5.notifyObserver("Вышел новый Game State с The Witcher 4");
        group6.notifyObserver("Пушистый котя");
        group7.notifyObserver("Тушканчик(большооой)");
    }
}