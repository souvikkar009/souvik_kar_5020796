package decorators;

import structures.Notifier;

public abstract class NotifierDecorator implements Notifier {
    Notifier notifier;

    public NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }

}
