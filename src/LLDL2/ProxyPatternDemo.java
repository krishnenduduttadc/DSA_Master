package LLDL2;

public class ProxyPatternDemo {

    // Main method
    public static void main(String[] args) {
        Video video1 = new ProxyVideo("movie.mp4");

        // Video will only load when played
        System.out.println("Proxy created. Video not loaded yet.");

        System.out.println("\nNow playing:");
        video1.play();  // loads and plays

        System.out.println("\nPlaying again:");
        video1.play();  // directly plays, doesn't load again
    }

    // Subject Interface
    interface Video {
        void play();
    }

    // Real Subject
    static class RealVideo implements Video {
        private String filename;

        public RealVideo(String filename) {
            this.filename = filename;
            loadFromDisk();  // simulate heavy operation
        }

        private void loadFromDisk() {
            System.out.println("Loading video: " + filename);
        }

        @Override
        public void play() {
            System.out.println("Playing video: " + filename);
        }
    }

    // Proxy
    static class ProxyVideo implements Video {
        private RealVideo realVideo;
        private String filename;

        public ProxyVideo(String filename) {
            this.filename = filename;
        }

        @Override
        public void play() {
            if (realVideo == null) {
                realVideo = new RealVideo(filename);  // lazy initialization
            }
            realVideo.play();
        }
    }
}

