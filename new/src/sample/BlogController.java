package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BlogController {

    @FXML
    private Button backButton;

    @FXML
    private void handleBackButton() throws IOException {
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Stage window = (Stage)backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }
}
