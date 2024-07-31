import adapters.FastPayAdapter;
import adapters.JuPayAdapter;
import adapters.RazorPayAdapter;
import structures.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor1 = new FastPayAdapter();
        System.out.println("Payment 1:");
        paymentProcessor1.processPayment();

        PaymentProcessor paymentProcessor2 = new JuPayAdapter();
        System.out.println("Payment 2:");
        paymentProcessor2.processPayment();

        PaymentProcessor paymentProcessor3 = new RazorPayAdapter();
        System.out.println("Payment 3:");
        paymentProcessor3.processPayment();
    }
}