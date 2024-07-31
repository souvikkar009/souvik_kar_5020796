package strategies;

import structures.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying through PayPal");
    }
}
