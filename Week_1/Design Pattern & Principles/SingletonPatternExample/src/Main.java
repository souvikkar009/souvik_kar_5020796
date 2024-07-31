public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger();
        System.out.println("Logger class object-1 hash value : " + logger1.hashCode());
        System.out.println("Trying to create one more Logger class object.");
        Logger logger2 = Logger.getLogger();
        System.out.println("Logger class object-2 hash value : " + logger2.hashCode());
    }
}