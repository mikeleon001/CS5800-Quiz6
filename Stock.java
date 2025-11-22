import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String symbol;
    private double price;
    private List<Observer> observers;

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }
}