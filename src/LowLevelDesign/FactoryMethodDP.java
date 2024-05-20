package LowLevelDesign;

public class FactoryMethodDP {
    // Logger interface (product)
    public interface Logger {
        void log(String message);
    }

    // ConsoleLogger class (concrete product)
    public static class ConsoleLogger implements Logger {
        @Override
        public void log(String message) {
            System.out.println("Console Logger: " + message);
        }
    }

    // FileLogger class (concrete product)
    public static class FileLogger implements Logger {
        @Override
        public void log(String message) {
            // For simplicity, we'll just simulate logging to a file
            System.out.println("File Logger: " + message);
        }
    }

    // LoggerFactory class (creator)
    public static abstract class LoggerFactory {
        // Factory method
        public abstract Logger createLogger();

        // Other methods that use the logger
        public void logMessage(String message) {
            Logger logger = createLogger();
            logger.log(message);
        }
    }

    // ConsoleLoggerFactory class (concrete creator)
    public static class ConsoleLoggerFactory extends LoggerFactory {
        @Override
        public Logger createLogger() {
            return new ConsoleLogger();
        }
    }

    // FileLoggerFactory class (concrete creator)
    public static class FileLoggerFactory extends LoggerFactory {
        @Override
        public Logger createLogger() {
            return new FileLogger();
        }
    }

    public static void main(String[] args) {
        // Create a ConsoleLoggerFactory
        LoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory();
        consoleLoggerFactory.logMessage("This is a console log message.");

        // Create a FileLoggerFactory
        LoggerFactory fileLoggerFactory = new FileLoggerFactory();
        fileLoggerFactory.logMessage("This is a file log message.");
    }
}
