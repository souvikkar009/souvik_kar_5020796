package receivers;

public class Light {
    private String lightStatus;
    private String lightName;


    public Light(String lightName) {
        this.lightName = lightName;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public String getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(String lightStatus) {
        this.lightStatus =lightStatus;
    }

    public void turnOnLight(){
        setLightStatus(this.getLightName() + " is on");
    }

    public void turnOffLight(){
        setLightStatus(this.getLightName() + " is off");
    }
}
