package LLDL2;

public class ChainOfResponsibilityDemo {

    // Main method
    public static void main(String[] args) {
        // Create the chain
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        // Start logging from highest level in the chain
        Logger loggerChain = errorLogger;

        loggerChain.logMessage(Logger.INFO, "This is an info message.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }

    // Handler Interface
    abstract static class Logger {
        public static final int INFO = 1;
        public static final int DEBUG = 2;
        public static final int ERROR = 3;

        protected int level;
        protected Logger nextLogger;

        public void setNextLogger(Logger nextLogger) {
            this.nextLogger = nextLogger;
        }

        public void logMessage(int level, String message) {
            if (this.level <= level) {
                write(message);
            }
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }

        protected abstract void write(String message);
    }

    // Concrete Handlers
    static class InfoLogger extends Logger {
        public InfoLogger() {
            this.level = INFO;
        }

        @Override
        protected void write(String message) {
            System.out.println("INFO: " + message);
        }
    }

    static class DebugLogger extends Logger {
        public DebugLogger() {
            this.level = DEBUG;
        }

        @Override
        protected void write(String message) {
            System.out.println("DEBUG: " + message);
        }
    }

    static class ErrorLogger extends Logger {
        public ErrorLogger() {
            this.level = ERROR;
        }

        @Override
        protected void write(String message) {
            System.out.println("ERROR: " + message);
        }
    }
}

