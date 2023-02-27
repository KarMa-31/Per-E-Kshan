package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class QuizController{

//    public ArrayList<Question> qList = new ArrayList<>();
//
//    public void initialize() {
//        Question q1 = new Question("When is Independence Day Celebrated in India?", "26th January",
//                "4th July", "31st October", "15th August", "15th August");
//        Question q2 = new Question("When is Republic Day Celebrated in India?", "4th July",
//                "26th January", "15th August", "31st October", "26th January");
//
//        qList = new ArrayList<Question>();
//        qList.add(q1);
//        qList.add(q2);
//    }

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button submitButton;
    @FXML
    private BorderPane MainPane;
    @FXML
    private Button exitButton;
    @FXML
    private RadioButton optA;
    @FXML
    private RadioButton optB;
    @FXML
    private RadioButton optC;
    @FXML
    private RadioButton optD;

    @FXML
    public void onButton1Click(ActionEvent event) throws FileNotFoundException {

        //System.out.println("Button 1 clicked");

        FXMLController object = new FXMLController();
        Pane view = object.getPane("q1");
        //System.out.println("This is Question 1");
        MainPane.setCenter(view);
    }

    public void onButton2Click(ActionEvent event) throws FileNotFoundException {

        //System.out.println("Button 2 clicked");

        FXMLController object = new FXMLController();
        Pane view = object.getPane("q2");
        //System.out.println("This is Question 2");
        MainPane.setCenter(view);

    }

    public void onButton3Click(ActionEvent event) throws FileNotFoundException {

        //System.out.println("Button 3 clicked");

        FXMLController object = new FXMLController();
        Pane view = object.getPane("q3");
        //System.out.println("This is Question 2");
        MainPane.setCenter(view);

    }

    @FXML
    private void handleExitButton(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void handleSubmitButton(ActionEvent event) throws IOException {

        for (int i = 0; i < Score.studentCopy.length; i++) {
            if( Score.studentCopy[i] == Score.answerCopy[i]) Score.score++;
        }

        System.out.println(Score.score + "/" + Score.answerCopy.length);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "score.fxml")));
        Stage window = (Stage) submitButton.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));

    }

    public void onRadioCheck1(ActionEvent event) throws IOException {

        System.out.println("option choosen");

        if(optA.isSelected()) Score.studentCopy[0] = 1;
        if(optB.isSelected()) Score.studentCopy[0] = 2;
        if(optC.isSelected()) Score.studentCopy[0] = 3;
        if(optD.isSelected()) Score.studentCopy[0] = 4;
    }

    public void onRadioCheck2(ActionEvent event){

        System.out.println("option choosen in q2");

        if(optA.isSelected()) Score.studentCopy[1] = 1;
        if(optB.isSelected()) Score.studentCopy[1] = 2;
        if(optC.isSelected()) Score.studentCopy[1] = 3;
        if(optD.isSelected()) Score.studentCopy[1] = 4;
    }

    public void onRadioCheck3(ActionEvent event){

        System.out.println("option choosen in q3");

        if(optA.isSelected()) Score.studentCopy[2] = 1;
        if(optB.isSelected()) Score.studentCopy[2] = 2;
        if(optC.isSelected()) Score.studentCopy[2] = 3;
        if(optD.isSelected()) Score.studentCopy[2] = 4;
    }

    //Thank you!



//    @FXML
//    public void onButtonClick(ActionEvent event){
//
//        try{
//            System.out.print("Loading");
//            Thread.sleep(1000);
//            System.out.print(".");
//            Thread.sleep(1000);
//            System.out.print(".");
//            Thread.sleep(1000);
//            System.out.println(".");
//            Thread.sleep(1000);
//            //Thread.sleep(10000);
//        }catch(InterruptedException e){
//            //karenge kuch
//        }
//
//        if(event.getSource().equals(helloButton))
//            System.out.println("Hello, " + nameField.getText());
//        if(event.getSource().equals(byeButton))
//            System.out.println("Bye, " + nameField.getText());
//
//    }
}
