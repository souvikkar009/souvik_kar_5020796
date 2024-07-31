package adapters;

import gateways.FastPay;
import structures.PaymentProcessor;

public class FastPayAdapter implements PaymentProcessor {
    FastPay fastPay = new FastPay();
    @Override
    public void processPayment() {
        fastPay.processPayment();
    }
}
