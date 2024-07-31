public class Logger {
    private static Logger logger = null;
    private Logger(){
        System.out.println("Logger class object created.");
    }
    public static Logger getLogger(){
        if (logger == null) logger = new Logger();
        return  logger;
    }
}
