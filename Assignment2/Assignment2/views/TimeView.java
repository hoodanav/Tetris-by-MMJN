package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.TetrisCommandDecrease;
import model.TetrisCommandIncrease;
import model.TetrisSpeedModifier;
import model.TetrisState;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Time Settings View
 *
 */
public class TimeView {
    private static final DecimalFormat df = new DecimalFormat("0");
    private Label question = new Label("Looking to change the speed?");
    private Label time = new Label("");
    private Button increase = new Button("Speed up!");
    private Button decrease = new Button("Slow down!");
    private TetrisSpeedModifier adjustUp = new TetrisSpeedModifier(new TetrisCommandIncrease(TetrisState.timer));
    private TetrisSpeedModifier adjustDown = new TetrisSpeedModifier(new TetrisCommandDecrease(TetrisState.timer));



    TetrisView tetrisView;

    /**
     * Constructor
     *
     * @param tetrisView master view
     */
    public TimeView(TetrisView tetrisView) {
        this.tetrisView = tetrisView;
        this.time.setText(TetrisState.timer.currPercent() * 100 + "%");

        tetrisView.paused = true;
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(tetrisView.stage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        time.setId("time");
        time.setStyle("-fx-text-fill: #e8e6e3;");
        time.setFont(new Font(16));
        time.setText("Current percent: " + df.format(TetrisState.timer.currPercent() * 100) + "%");

        question.setId("question");
        question.setStyle("-fx-text-fill: #e8e6e3;");
        question.setFont(new Font(16));

        increase.setId("increase");
        increase.setStyle("-fx-background-color: #a8577e; -fx-text-fill: white;");
        increase.setPrefSize(200, 50);
        increase.setFont(new Font(16));
        increase.setOnAction(e -> {
            adjustUp.changeTime();
            this.time.setText("Current percent: " + df.format(TetrisState.timer.currPercent() * 100) + "%");
            tetrisView.timeline.setRate(TetrisState.timer.currTime());
        });

        decrease.setId("decrease");
        decrease.setStyle("-fx-background-color: #3b429f; -fx-text-fill: white;");
        decrease.setPrefSize(200, 50);
        decrease.setFont(new Font(16));
        decrease.setOnAction(e -> {
            adjustDown.changeTime();
            this.time.setText("Current percent: " + df.format(TetrisState.timer.currPercent() * 100) + "%");
            tetrisView.timeline.setRate(TetrisState.timer.currTime());
        });

        VBox titleBox = new VBox(10, question);
        titleBox.setAlignment(Pos.CENTER);

        VBox curr = new VBox(5, time);
        curr.setAlignment(Pos.CENTER);

        VBox options = new VBox(10, increase, decrease);
        options.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(titleBox);
        dialogVbox.getChildren().add(curr);
        dialogVbox.getChildren().add(options);
        Scene dialogScene = new Scene(dialogVbox, 300, 250);
        dialog.setScene(dialogScene);
        dialog.show();
        dialog.setOnCloseRequest(event -> {
            tetrisView.paused = false;
        });
    }
}
