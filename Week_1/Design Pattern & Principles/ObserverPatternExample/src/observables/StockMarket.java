package observables;

import observableStructures.Stock;
import observerStructures.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private String info;

    private List<Observer> observers = new ArrayList<>();

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    @Override
    public void register(String stockName) {
        setInfo("Registered in stock: " + stockName);
    }

    @Override
    public void deRegister(String stockName) {
        setInfo("Deregistered in stock: " + stockName);
    }

    @Override
    public void doNotify() {
        for (Observer observer : this.observers){
            observer.update(this.getInfo());
        }
    }
}
