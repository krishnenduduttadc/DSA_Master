package LowLevelDesign;

public class AdapterDP {
    // MediaPlayer interface
    public interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // AdvancedMediaPlayer interface
    public interface AdvancedMediaPlayer {
        void playMp3(String fileName);

        void playMp4(String fileName);
    }

    // Mp3Player class
    public static class Mp3Player implements AdvancedMediaPlayer {
        @Override
        public void playMp3(String fileName) {
            System.out.println("Playing MP3 file: " + fileName);
        }

        @Override
        public void playMp4(String fileName) {
            // Do nothing
        }
    }

    // Mp4Player class
    public static class Mp4Player implements AdvancedMediaPlayer {
        @Override
        public void playMp3(String fileName) {
            // Do nothing
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing MP4 file: " + fileName);
        }
    }

    // MediaAdapter class (Adapter)
    public static class MediaAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedMediaPlayer;

        public MediaAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
            this.advancedMediaPlayer = advancedMediaPlayer;
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                advancedMediaPlayer.playMp3(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer.playMp4(fileName);
            }
        }
    }

    // AudioPlayer class
    public static class AudioPlayer implements MediaPlayer {
        private MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file: " + fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(new Mp4Player());
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media type: " + audioType);
            }
        }
    }


    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("avi", "video.avi");
    }
}
