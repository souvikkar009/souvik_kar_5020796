import models.Computer;

public class Main {
    public static void main(String[] args) {
        Computer myLaptop = new Computer
                .Builder()
                .setCPU("Intel i5")
                .setCPU_Gen(12)
                .setCPU_Manufacturer("intel")
                .setRAM(16)
                .setDisplaySize(14)
                .setDisplayResolution("2880x1800")
                .setGPU("Intel Iris Xe Integrated")
                .build();
        System.out.println(myLaptop);
    }
}