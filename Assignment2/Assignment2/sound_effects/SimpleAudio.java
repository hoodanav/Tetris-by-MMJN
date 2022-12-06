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

        // moved block left
        if (arg.equals(TetrisView.LEFT_MOVE) && TetrisView.getVoiceEnabled()) {
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
        // if row filled
        else if (arg.equals(TetrisModel.ROW_FILLED) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//row_filled_a.wav");
        }
        // bomb use voice aid
        else if (arg.equals(TetrisBoard.BOMB_USED) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//bomb_clear_a.wav");
        }
        else if (arg.equals(TetrisView.FAST_DROP) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//drop.wav");
        }
        // level normal voice aid
        else if (arg.equals(TetrisModel.NORMAL_LEVEL) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//normal.wav");
        }
        // level easy voice aid
        else if (arg.equals(TetrisModel.EASY_LEVEL) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//.wav");
        }
        // level hard voice aid
        else if (arg.equals(TetrisModel.HARD_LEVEL) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//hard.wav");
        }
        // level expert voice aid
        else if (arg.equals(TetrisModel.EXPERT_LEVEL) && TetrisView.getVoiceEnabled()) {
            play("Assignment2//sounds//expert.wav");
        }
        // level up general sound
        else if (arg.equals(TetrisModel.EASY_LEVEL) || arg.equals(TetrisModel.NORMAL_LEVEL) || arg.equals(TetrisModel.HARD_LEVEL) || arg.equals(TetrisModel.EXPERT_LEVEL)) {
            play("Assignment2//sounds//level_up.wav");
        }

        else if (arg.equals(TetrisModel.ROW_FILLED)) {
            play("Assignment2//sounds//line_filled.wav");

            // piece placed
        }
        else if (arg.equals(TetrisModel.PIECE_PLACED)) {
            play("Assignment2//sounds//piece_placed.wav");
        }
        // bomb use normal
        else if (arg.equals(TetrisBoard.BOMB_USED)) {
            play("Assignment2//sounds//bomb_clear.wav");
        }

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