package observableStructures;

public interface Stock {
    public void register(String stockName);
    public void deRegister(String stockName);
    public void doNotify(); // can not make it notify
}
