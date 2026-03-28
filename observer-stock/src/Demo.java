import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(float price);
}

class StockExchange implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

class MobileDisplay implements Observer {
    private String name;

    public MobileDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " display updated with stock price: $" + price);
    }
}

public class Demo {
    public static void main(String[] args) {
        StockExchange nse = new StockExchange();

        Observer user1 = new MobileDisplay("Kaif Mobile");
        Observer user2 = new MobileDisplay("iPad Air");

        nse.registerObserver(user1);
        nse.registerObserver(user2);

        System.out.println("Updating price to $100.50...");
        nse.setPrice(100.50f);

        nse.removeObserver(user1);

        System.out.println("\nUpdating price to $105.75...");
        nse.setPrice(105.75f);
    }
}
