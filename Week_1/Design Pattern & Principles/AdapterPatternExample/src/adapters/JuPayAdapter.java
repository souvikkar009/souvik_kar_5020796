package adapters;

import gateways.JuPay;
import structures.PaymentProcessor;

public class JuPayAdapter implements PaymentProcessor {
    JuPay juPay = new JuPay();
    @Override
    public void processPayment() {
        juPay.processPayment();
    }
}
