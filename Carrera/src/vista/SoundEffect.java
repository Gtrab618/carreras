
package vista;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {

    private Clip audioClip;
    private AudioInputStream audioStream;

    //Obtener el clip pa poder usarlo luego
    public SoundEffect(String pathSonido) {
        File audioFile = new File(pathSonido);
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        AudioFormat format = audioStream.getFormat();
       

        //Guardamos el clip
        try {
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void PlaySound() {
        new Thread(() -> {
            audioClip.setFramePosition(0);
            audioClip.start();
        }) {
        }.start();
    }

    public void loopMusic() {
        new Thread( () -> {
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }){}.start();
    }

    public void stopSounds() {
        audioClip.stop();
    }

}