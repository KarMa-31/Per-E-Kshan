package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomePage.fxml")));
        primaryStage.setTitle("Per-E-Kshan");
        primaryStage.setScene(new Scene(root, 1550, 800));
        //primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }
    public static void main(String[] args) {
        launch(args);
    }
}


