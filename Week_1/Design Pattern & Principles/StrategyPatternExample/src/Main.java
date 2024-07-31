import contexts.PaymentContext;
import strategies.CreditCardPayment;
import strategies.PayPalPayment;

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext1 = new PaymentContext(new PayPalPayment());
        paymentContext1.executePayment();
        PaymentContext paymentContext2 = new PaymentContext(new CreditCardPayment());
        paymentContext2.executePayment();
    }
}