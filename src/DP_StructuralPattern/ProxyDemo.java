package DP_StructuralPattern;


//Controls access to real object.
//Acts as placeholder.
//Adds security/logging.
//Same interface as real object.

interface Service {
    void run();
}

class RealService implements Service {
    public void run() {
        System.out.println("Running");
    }
}

class ProxyService implements Service {
    Service s = new RealService();

    public void run() {
        s.run();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        new ProxyService().run();
    }
}

