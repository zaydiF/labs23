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
        User user1 = new User("Dima");
        User user2 = new User("Kirill");

        Group group1 = new Group("ITproer");
        Group group2 = new Group("CyberArena");
        Group group3 = new Group("DRIFT ");
        Group group4 = new Group("IT-Колледж");
        Group group5 = new Group("JDM");
        Group group6 = new Group("CS GO2");
        Group group7 = new Group("Melon Music");

        group1.addObserver(user1);
        group2.addObserver(user1);
        group3.addObserver(user1);

        group4.addObserver(user2);
        group5.addObserver(user2);
        group6.addObserver(user2);
        group7.addObserver(user2);

        group1.notifyObserver("Сайт за час");
        group2.notifyObserver("Турнир по играм");
        group3.notifyObserver("Гонки дрифт гача япония");
        group4.notifyObserver("Новости Колледж");
        group5.notifyObserver("Тюнинг  Авто");
        group6.notifyObserver("Новости по кс");
        group7.notifyObserver("Музыка");
    }
}
