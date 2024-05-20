package LowLevelDesign;

public class AbstractFactoryDP {
    // Abstract product for Button
    public interface Button {
        void paint();
    }

    // Abstract product for Checkbox
    public interface Checkbox {
        void paint();
    }

    // Concrete product for Windows Button
    public static class WindowsButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a button in Windows style.");
        }
    }

    // Concrete product for Windows Checkbox
    public static class WindowsCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a checkbox in Windows style.");
        }
    }

    // Concrete product for MacOS Button
    public static class MacOSButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a button in MacOS style.");
        }
    }

    // Concrete product for MacOS Checkbox
    public static class MacOSCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a checkbox in MacOS style.");
        }
    }


    // Abstract factory interface
    public interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    // Concrete factory for Windows
    public static class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    // Concrete factory for MacOS
    public static class MacOSFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    public static class Application {
        private Button button;
        private Checkbox checkbox;

        public Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        public void paint() {
            button.paint();
            checkbox.paint();
        }
    }


    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            factory = new WindowsFactory();
        } else if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported operating system.");
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
