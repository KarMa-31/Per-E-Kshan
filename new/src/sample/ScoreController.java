package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ScoreController {

    @FXML
    private Label scoreLabel;
    @FXML
    private Button homeButton;

    @FXML
    public void setScoreLabel() {
        scoreLabel.setText("Your Score is " + Score.score + "/" + Score.answerCopy.length);
    }

    @FXML
    public void handleHomeButton() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Stage window = (Stage)homeButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
    }
}
