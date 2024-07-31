import decorators.SMSDecorator;
import decorators.SlackNotifierDecorator;
import notifiers.EmailNotifier;
import structures.Notifier;

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new SMSDecorator(new SlackNotifierDecorator(new EmailNotifier()));
        notifier.send();
    }
}