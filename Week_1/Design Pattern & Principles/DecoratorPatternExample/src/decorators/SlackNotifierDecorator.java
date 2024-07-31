package decorators;

import structures.Notifier;

public class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }


    @Override
    public void send() {
        notifier.send();
        System.out.println("Slack Notification");
    }
}
