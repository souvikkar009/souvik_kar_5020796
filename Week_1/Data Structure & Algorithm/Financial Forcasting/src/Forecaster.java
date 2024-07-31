public class Forecaster {
    private double initialValue;
    private double[] growthRates;
    private int timePeriod;

    public Forecaster() {
    }

    public Forecaster(double initialValue, double[] growthRates, int timePeriod) {
        this.initialValue = initialValue;
        this.growthRates = growthRates;
        this.timePeriod = timePeriod;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double[] getGrowthRates() {
        return growthRates;
    }

    public void setGrowthRates(double[] growthRates) {
        this.growthRates = growthRates;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public double predictFutureValue(double initialValue, double[] growthRates, int timePeriod){
        if (timePeriod == 0) {
            return initialValue;
        }
        return predictFutureValue(initialValue, growthRates, timePeriod - 1) * ((1 + growthRates[timePeriod - 1] / 100));
    }
}
