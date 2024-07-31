package observers;

import observerStructures.Observer;

public class WebApp implements Observer {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void update(String info) {
        this.setInfo(info);
    }
}
