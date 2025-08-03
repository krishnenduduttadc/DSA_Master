package DesignPatternL1;

public class SingletonDP {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger = Logger.getInstance();

        // Use the logger to log messages
        logger.log("This is the first log message.");
        logger.log("This is the second log message.");

        // Attempt to get another instance of Logger
        Logger anotherLogger = Logger.getInstance();

        // Check if both logger instances are the same
        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger));
    }

    public static class Logger {
        // Private static instance of the singleton class
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code here
        }

        // Public static method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("Log message: " + message);
        }
    }
}
