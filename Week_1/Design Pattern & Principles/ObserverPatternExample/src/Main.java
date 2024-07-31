import observables.StockMarket;
import observers.MobileApp;
import observers.WebApp;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();
        stockMarket.addObserver(mobileApp);
        stockMarket.addObserver(webApp);
        stockMarket.register("TATA");
        stockMarket.doNotify();
        System.out.println("Mobile app: " + mobileApp.getInfo());
        System.out.println("Web app: " + webApp.getInfo());
        stockMarket.deRegister("ITC");
        stockMarket.doNotify();
        System.out.println("Mobile app: " + mobileApp.getInfo());
        System.out.println("Web app: " + webApp.getInfo());
    }
}