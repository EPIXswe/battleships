package segerfast.philip.utils;
import javax.sound.sampled.*;
import java.io.File;

public class SoundUtils {

    private static final String RESOURCE_PATH = "./src/resources/";

    private static Clip menuMusicClip;
    private static FloatControl menuMusicVolumeControl = null;

    public enum GameSound {
        CANNON_1(RESOURCE_PATH + "cannon1.wav");

        private final File file;
        private final String path;

        private GameSound(String filePath) {
            this.path = filePath;
            file = new File(filePath);
        }

        public String toString() {
            return path;
        }
    }

    public enum GameMusic {
        AGE_OF_EMPIRES(RESOURCE_PATH + "aoe2.wav");

        private final File file;

        private final String path;

        private GameMusic(String filePath) {
            this.path = filePath;
            file = new File(filePath);
        }

        public String toString() {
            return path;
        }
    }

    static {
        initGameMenuMusic();
    }

    public static void playSound(GameSound sound) {
        try {
            Clip clip = AudioSystem.getClip();
            // getAudioInputStream() also accepts a File or InputStream
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound.file);
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loopSound(GameSound sound) {
        try {
            Clip clip = AudioSystem.getClip();
            // getAudioInputStream() also accepts a File or InputStream
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound.file);
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initGameMenuMusic() {

        try {
            menuMusicClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(GameMusic.AGE_OF_EMPIRES.file);
            menuMusicClip.open(ais);
            menuMusicVolumeControl = (FloatControl) menuMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
            menuMusicVolumeControl.setValue(-30.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playGameMenuMusic() {
        menuMusicVolumeControl.setValue(-30.0f);
        menuMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stopGameMenuMusic() {
        menuMusicClip.stop();
        menuMusicClip.setFramePosition(0);
    }
}