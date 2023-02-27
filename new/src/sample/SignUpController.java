package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class SignUpController {

    @FXML
    private Button signUp;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button exitButton;
    @FXML
    private Button backButton;

    public void handleCreateAccount(){

        String name = "UserName: " + userName.getText();
        String ps = "Password: " + pwd.getText();

        System.out.println(name);
        System.out.println(ps);

        try {

            File f = new File("E:/College/Sem - 3/OOP/Innovative/UserDatabase.txt");
            Scanner dataReader = new Scanner(f);

            boolean userExists = false;

            while(dataReader.hasNextLine()){

                String s = dataReader.nextLine();
                if(s.equals(name)){
                    userExists = true;


                    var alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Username already exists!");
                    alert.setContentText("Please choose different Username");

                    alert.show();
                }

            }

            if(!userExists) {

                if(userName.getText().equals("")){
                    var alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("ERROR!");
                    alert.setHeaderText("Username can NOT be empty");
                    alert.setContentText("Please enter a valid username.");
                    alert.show();
                }else if(pwd.getText().equals("")) {
                    var alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("ERROR!");
                    alert.setHeaderText("Password can NOT be empty");
                    alert.setContentText("Please enter password.");
                    alert.show();
                }else {

                    FileWriter fw = new FileWriter("E:/College/Sem - 3/OOP/Innovative/UserDatabase" +
                            ".txt", true);

                    fw.write("\n" + name + "\n");
                    fw.write(ps + "\n");

                    fw.flush(); // empty buffer in the file
                    fw.close(); // close the file to allow opening by others applications

                    fw = new FileWriter("E:/College/Sem - 3/OOP/Innovative/UserActivity" +
                            ".txt", true);

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy/ HH:mm:ss");
                    Date today = Calendar.getInstance().getTime();
                    String date = dateFormat.format(today);

                    fw.write("\n" + "***New user sign up: " + "\n");
                    fw.write(name + " @time: " + date + "\n");

                    fw.flush(); // empty buffer in the file
                    fw.close(); // close the file to allow opening by others applications


                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
                    Stage window = (Stage) signUp.getScene().getWindow();
                    window.setScene(new Scene(root, 1537, 810));

                    window.setMaximized(true);
                    window.getIcons().add(new Image("E:/College/Sem - " +
                            "3/OOP/Innovative/new/Logo/LOGOicon" +
                            ".PNG"));
                }
            }
        }catch(Exception e){
            System.out.println("file not found");
        }
    }

    @FXML
    private void handleExitButton(){
        Stage stage = (Stage) exitButton.getScene().getWindow(); // get a handle to the stage
        stage.close(); // do what you have to do
    }

    @FXML
    private void handleBackButton() throws IOException {
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomePage.fxml")));
        Stage window = (Stage)backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1530, 800));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }

}
