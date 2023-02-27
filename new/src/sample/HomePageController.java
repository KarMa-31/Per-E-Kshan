package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomePageController {

    @FXML
    private Button quizButton;
    @FXML
    private Button timerButton;
    @FXML
    private Button blogButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button logoutButton;

    @FXML
    public void handleQuizButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("quiz.fxml")));
        Stage window = (Stage)quizButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }

    @FXML
    public void handleTimerButton() throws IOException {

        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("timer2.fxml")));
        Stage window = (Stage)timerButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));

        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Coming Soon!");
        alert.setHeaderText("This feature is still under development!");
        alert.setContentText("Please check again later");
        alert.show();
    }

    @FXML
    public void handleBlogButton() throws IOException {
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("blog.fxml")));
        Stage window = (Stage)blogButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }

    @FXML
    private void handleExitButton(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void handleLogoutButton() throws IOException {
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomePage.fxml")));
        Stage window = (Stage)logoutButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }

}
