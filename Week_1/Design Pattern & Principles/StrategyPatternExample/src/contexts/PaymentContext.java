package contexts;

import structures.PaymentStrategy;

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(){
        paymentStrategy.pay();
    }
}
