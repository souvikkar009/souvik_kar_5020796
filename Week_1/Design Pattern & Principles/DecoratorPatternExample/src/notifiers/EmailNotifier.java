package notifiers;

import structures.Notifier;

public class EmailNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("Email Notification");
    }
}
