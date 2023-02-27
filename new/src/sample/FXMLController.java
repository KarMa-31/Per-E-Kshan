package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FXMLController {

    private Pane view;

    public Pane getPane(String filename){
        try{
            URL fileurl = QuizController.class.getResource(filename+".fxml");

            if (filename==null){
                throw new java.io.FileNotFoundException("FXML file not found!!") ;
            }
            System.out.println("found it!");
            new FXMLLoader();
            view = FXMLLoader.load(fileurl);
        }
        catch (IOException e){
            System.out.println("Bingo");
        }
        return view;
    }
}
