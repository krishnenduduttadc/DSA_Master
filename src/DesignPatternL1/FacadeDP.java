package DesignPatternL1;

public class FacadeDP {

    public static void main(String[] args) {
        // Create subsystem components
        Amplifier amplifier = new Amplifier();
        Tuner tuner = new Tuner();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        // Create a facade for the home theater system
        HomeTheaterFacade facade = new HomeTheaterFacade(amplifier, tuner, dvdPlayer, projector, lights);

        // Start watching a movie using the facade
        facade.watchMovie();

        // End the movie and shut down the home theater
        facade.endMovie();
    }

    // Amplifier class
    static class Amplifier {
        void on() {
            System.out.println("Amplifier is on");
        }

        void off() {
            System.out.println("Amplifier is off");
        }
    }

    // Tuner class
    static class Tuner {
        void on() {
            System.out.println("Tuner is on");
        }

        void off() {
            System.out.println("Tuner is off");
        }
    }

    // DVDPlayer class
    static class DVDPlayer {
        void on() {
            System.out.println("DVD Player is on");
        }

        void off() {
            System.out.println("DVD Player is off");
        }
    }

    // Projector class
    static class Projector {
        void on() {
            System.out.println("Projector is on");
        }

        void off() {
            System.out.println("Projector is off");
        }
    }

    // Lights class
    static class Lights {
        void dim() {
            System.out.println("Lights are dimmed");
        }

        void brighten() {
            System.out.println("Lights are brightened");
        }
    }

    // HomeTheaterFacade class
    public static class HomeTheaterFacade {
        private Amplifier amplifier;
        private Tuner tuner;
        private DVDPlayer dvdPlayer;
        private Projector projector;
        private Lights lights;

        public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, DVDPlayer dvdPlayer, Projector projector, Lights lights) {
            this.amplifier = amplifier;
            this.tuner = tuner;
            this.dvdPlayer = dvdPlayer;
            this.projector = projector;
            this.lights = lights;
        }

        public void watchMovie() {
            System.out.println("Get ready to watch a movie...");
            lights.dim();
            projector.on();
            dvdPlayer.on();
            amplifier.on();
            tuner.on();
        }

        public void endMovie() {
            System.out.println("Shutting down the home theater...");
            tuner.off();
            amplifier.off();
            dvdPlayer.off();
            projector.off();
            lights.brighten();
        }
    }
}
