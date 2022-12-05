package sound_effects;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.TetrisBoard;
import model.TetrisModel;
import views.TetrisView;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class SimpleAudio implements Observer {
    public SimpleAudio() {

    }

    @Override
    public void update(Observable o, Object arg) {
        // if row filled
        if (arg.equals(TetrisModel.ROW_FILLED)) {
          play("Assignment2//sounds//line_filled.wav");

          // piece placed
        }
        else if (arg.equals(TetrisModel.PIECE_PLACED)) {
            play("Assignment2//sounds//piece_placed.wav");
        }
        // moved block left
        else if (arg.equals(TetrisView.LEFT_MOVE) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//lefty.wav");
        }
        // moved block right
        else if (arg.equals(TetrisView.RIGHT_MOVE) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//right.wav");
        }
        // rotated block
        else if (arg.equals(TetrisView.ROTATED) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//turning.wav");
        }

        else if (arg.equals(TetrisBoard.BOMB_USED)) {
            play("Assignment2//sounds//bomb_clear.wav");
        }

        /*else if (arg.equals(TetrisModel.GAME_STARTED)) {
            play("Assignment2//sounds//game_music.wav");
        }*/






    }

    public void play(String sound)
    {
        AudioInputStream  audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
            // create clip reference
            clip = AudioSystem.getClip();
            // open audioInputStream to the clip
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }
}