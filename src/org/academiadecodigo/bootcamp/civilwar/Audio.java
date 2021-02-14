package org.academiadecodigo.bootcamp.civilwar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Audio {

    private AudioInputStream audioInputStream;
    private Clip clip;
    private URL audioURL;
    private String path;
    private File file;

    public Audio(int caseAudio) {
        try {
            if (caseAudio == 1) {
                path = AudioResources.returnAudio(caseAudio);
            }else if (caseAudio == 2){
                path = AudioResources.returnAudio(caseAudio);
            }else if (caseAudio == 3){
                path = AudioResources.returnAudio(caseAudio);
            }


            audioURL = getClass().getClassLoader().getResource(path);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void playInGameMusic() {
        try {
            if (audioURL == null) {
                file = new File("D:/Biblioteca/Academia_de_Codigo/Projectos/CivilWar/resources/" + path);
                audioURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(audioURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playSound() {
        try {
            if (audioURL == null) {
                file = new File("D:/Biblioteca/Academia_de_Codigo/Projectos/CivilWar/resources/" + path);
                audioURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(audioURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopSound() {
        clip.stop();
        clip.flush();
        clip.close();
    }


}