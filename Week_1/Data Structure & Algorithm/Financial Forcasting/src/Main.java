import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Financial Forecasting ***");
        Forecaster forecaster = new Forecaster();
        System.out.println("Enter the initial value: ");
        forecaster.setInitialValue(sc.nextDouble());
        sc.nextLine();
        System.out.println("Enter time period: ");
        forecaster.setTimePeriod(sc.nextInt());
        sc.nextLine();
        double[] growthRates = new double[forecaster.getTimePeriod()];
        System.out.println("Enter the growth values in %:");
        for (int i = 0; i < forecaster.getTimePeriod(); i++){
            System.out.print("Growth value in period " + (i + 1) + " : ");
            growthRates[i] = sc.nextDouble();
        }
        sc.nextLine();
        forecaster.setGrowthRates(growthRates);
        System.out.println("Predicted value at time " + forecaster.getTimePeriod() + " : " + (double) Math.round(
                forecaster.predictFutureValue(forecaster.getInitialValue(),
                        forecaster.getGrowthRates(), forecaster.getTimePeriod())));
    }
}