package strategies;

import structures.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying through credit card.");
    }
}
