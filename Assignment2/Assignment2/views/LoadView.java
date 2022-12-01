package views;

import model.TetrisBoard;
import model.TetrisModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Load File View
 *
 * Based on the Tetris assignment in the Nifty Assignments Database, authored by Nick Parlante
 */
public class LoadView {

    private TetrisView tetrisView;
    private Label selectBoardLabel;
    private Button selectBoardButton;
    private ListView<String> boardsList;


    /**
     * Constructor
     *
     * @param tetrisView master view
     */
    public LoadView (TetrisView tetrisView) {
        tetrisView.paused = true;
        this.tetrisView = tetrisView;
        selectBoardLabel = new Label(String.format("Currently playing: Default Board"));
        boardsList = new ListView<>(); //list of tetris.boards

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(tetrisView.stage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        selectBoardLabel.setId("CurrentBoard"); // DO NOT MODIFY ID

        boardsList.setId("BoardsList");  // DO NOT MODIFY ID
        boardsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getFiles(boardsList); //get files for file selector

        selectBoardButton = new Button("Change board");
        selectBoardButton.setId("ChangeBoard"); // DO NOT MODIFY ID

        //on selection, do something
        selectBoardButton.setOnAction(e -> {
            try {
                selectBoard(selectBoardLabel, boardsList);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox selectBoardBox = new VBox(10, selectBoardLabel, boardsList, selectBoardButton);

        // Default styles which can be modified
        boardsList.setPrefHeight(100);

        selectBoardLabel.setStyle("-fx-text-fill: #e8e6e3");
        selectBoardLabel.setFont(new Font(16));

        selectBoardButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        selectBoardButton.setPrefSize(200, 50);
        selectBoardButton.setFont(new Font(16));

        selectBoardBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(selectBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
        dialog.setOnCloseRequest(event -> {
            tetrisView.paused = false;
        });
    }


    private void getFiles(ListView<String> listView) {
        try {
            File directoryPath = new File("boards");
            //List of all files and directories
            File  files[] = directoryPath.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isFile() && files[i].getName().endsWith(".ser")){
                    listView.getItems().add(files[i].getName());
                }
            }
        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }

    /**
     * Select and load the board file selected in the boardsList and update selectBoardLabel with the name of the new Board file
     *
     * @param selectBoardLabel a message Label to update which board is currently selected
     * @param boardsList a ListView populated with tetris.boards to load
     */
    private void selectBoard(Label selectBoardLabel, ListView<String> boardsList) throws IOException {
        //throw new UnsupportedOperationException(); //replace this!
        String selectedItem = boardsList.getSelectionModel().getSelectedItem();
        FileInputStream fis = new FileInputStream("boards/"+selectedItem);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Object obj = ois.readObject();
            tetrisView.model =(TetrisModel)obj;
            selectBoardLabel.setText(selectedItem);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Load the board from a file
     *
     * @param boardFile file to load
     * @return loaded Tetris Model
     */
    public TetrisModel loadBoard(String boardFile) throws IOException {
        System.out.println("boardFile: " + boardFile);

        // Reading the object from a file
        FileInputStream file = null;
        ObjectInputStream in = null;
        try {
            file = new FileInputStream(boardFile);
            in = new ObjectInputStream(file);
            return (TetrisModel) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            file.close();
        }
    }
}
