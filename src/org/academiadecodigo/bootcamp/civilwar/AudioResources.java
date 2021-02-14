package org.academiadecodigo.bootcamp.civilwar;

public class AudioResources {

    private static final String GAMEMUSIC = "Audio/gamemusic.wav";
    private static final String DEATHSOUND = "Audio/deathsound.wav";
    private static final String LIVESSOUND = "Audio/lives.wav";


    public static String getGamemusic() {
        return GAMEMUSIC;
    }

    public static String getDeathsound() {
        return DEATHSOUND;
    }

    public static String getLivesSound(){
        return LIVESSOUND;
    }

    public static String returnAudio(int caseAudio) {

        String getMusic = getGamemusic();

        switch (caseAudio) {

            case 1:
                getMusic = getGamemusic();
                break;


            case 2:
                getMusic = getDeathsound();
                break;

            case 3:
                getMusic = getLivesSound();
                break;

        }
        return getMusic;
    }


}

