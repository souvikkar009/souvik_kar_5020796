package models;

public class Computer {
    private String CPU;
    private String CPU_Manufacturer;
    private int CPU_Gen;
    private int RAM;
    private int storage;
    private float displaySize;
    private String displayResolution;
    private String GPU;
    private int GPU_Memory;

    public String getCPU() {
        return CPU;
    }

    public String getCPU_Manufacturer() {
        return CPU_Manufacturer;
    }

    public int getCPU_Gen() {
        return CPU_Gen;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public float getDisplaySize() {
        return displaySize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public String getGPU() {
        return GPU;
    }

    public int getGPU_Memory() {
        return GPU_Memory;
    }

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.CPU_Manufacturer = builder.CPU_Manufacturer;
        this.CPU_Gen = builder.CPU_Gen;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.displayResolution = builder.displayResolution;
        this.displaySize = builder.displaySize;
        this.GPU = builder.GPU;
        this.GPU_Memory = builder.GPU_Memory;
    }

    public static class Builder{
        private String CPU;
        private String CPU_Manufacturer;
        private int CPU_Gen;
        private int RAM;
        private int storage;
        private float displaySize;
        private String displayResolution;
        private String GPU;
        private int GPU_Memory;

        public Builder() {
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setCPU_Manufacturer(String CPU_Manufacturer) {
            this.CPU_Manufacturer = CPU_Manufacturer;
            return this;
        }

        public Builder setCPU_Gen(int CPU_Gen) {
            this.CPU_Gen = CPU_Gen;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setDisplaySize(float displaySize) {
            this.displaySize = displaySize;
            return this;
        }

        public Builder setDisplayResolution(String displayResolution) {
            this.displayResolution = displayResolution;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setGPU_Memory(int GPU_Memory) {
            this.GPU_Memory = GPU_Memory;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer\n{\n" +
                "CPU = '" + CPU + '\''+ ",\n" +
                "CPU_Manufacturer = '" + CPU_Manufacturer + '\'' + "\n" +
                "CPU_Gen = " + CPU_Gen + ",\n" +
                "RAM = " + RAM + ",\n" +
                "storage = " + storage + ",\n" +
                "displaySize = " + displaySize + ",\n" +
                "displayResolution = '" + displayResolution + '\'' + ",\n" +
                "GPU = '" + GPU + '\'' + ",\n" +
                "GPU_Memory = '" + GPU_Memory + '\'' + ",\n" +
                '}';
    }
}
