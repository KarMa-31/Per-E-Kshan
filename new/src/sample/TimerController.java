package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerController implements Initializable{

    @FXML
    private Button stop;

    @FXML
    private TextField timerHours;

    @FXML
    private TextField timerMinutes;

    @FXML
    private TextField timerSeconds;

    @FXML
    private GridPane menuPane;

    @FXML
    private AnchorPane timerPane;

    @FXML
    private ComboBox<Integer> hours;

    @FXML
    private ComboBox<Integer> minutes;

    @FXML
    private ComboBox<Integer> seconds;

    @FXML
    private Button start;

    @FXML
    private Button back;

    @FXML
    private AnchorPane MainPane;

    Map<Integer, String> numberMap;
    Integer currsecond;
    Thread thrd;

    @FXML
    void start(ActionEvent event) throws FileNotFoundException {
        String h = hours.getValue().toString();
        String m = minutes.getValue().toString();
        String s = seconds.getValue().toString();
        currsecond = Integer.parseInt(hmstosecond(Integer.parseInt(h),
                Integer.parseInt(m),
                Integer.parseInt(s)).toString());
        hours.setValue(0);
        minutes.setValue(0);
        seconds.setValue(0);
        // timer executing fxml should be loaded
        scrollUp();
    }

    void countdown()
    {
        thrd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        //countdown here

                        if(currsecond!=0)
                        {setOutput();}
                        Thread.sleep(1000);
                        if(currsecond==0)
                        {
                            System.out.println("finished ... ");
                            //upper fxml(timer input fxml)
                            scrollUp();
                            thrd.stop();
                        }
                        currsecond--;
                    }
                }
                catch(Exception e)
                {
                    //exception handle
                }
            }
        });
        thrd.start();
    }
    //function for executing timer input fxml

    // function for executing timer fxml

    @FXML
    void setOutput()
    {
        LinkedList<Integer> hms = secondstohms(currsecond);
        timerHours.setText(numberMap.get(hms.get(0)));
        timerMinutes.setText(numberMap.get(hms.get(1)));
        timerSeconds.setText(numberMap.get(hms.get(2)));
        System.out.println(hms.get(0)+"-"+hms.get(1)+"-"+hms.get(2));

    }

    @FXML
    void unstart(ActionEvent event)
    {
        thrd.stop();
        // timer input fxml file should be loaded
        scrolldown();
    }

    void scrollUp()
    {
        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(100));
        tr1.setToX(0);
        tr1.setToY(200);
        tr1.setNode(menuPane);
        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(100));
        tr2.setToX(0);
        tr2.setToY(200);
        tr2.setNode(timerPane);
        ParallelTransition pt1 = new ParallelTransition(tr1,tr2);
        pt1.setOnFinished(event -> {
            try {
                System.out.println("Start CountDown");
                countdown();
            }catch (Exception e2) {

            }
        });
    }

    void scrolldown()
    {
        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(100));
        tr1.setToX(0);
        tr1.setToY(200);
        tr1.setNode(timerPane);
        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(100));
        tr2.setToX(0);
        tr2.setToY(200);
        tr2.setNode(menuPane);
        ParallelTransition pt1 = new ParallelTransition(tr1,tr2);
        pt1.setOnFinished(event -> {
            try {
                thrd.stop();
            }catch (Exception e2)
            {

            }
        });
    }
    Integer hmstosecond(Integer h,Integer m,Integer s)
    {
        Integer htos = h*3600;
        Integer mtos = m*60;
        Integer total = htos+mtos+s;
        return total;
    }
    LinkedList<Integer> secondstohms(Integer currsecond)
    {
        Integer hour = currsecond/3600;
        currsecond = currsecond%3600;
        Integer minute = currsecond/60;
        currsecond = currsecond%60;
        Integer second = currsecond;
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(hour);
        ans.add(minute);
        ans.add(second);
        return ans;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Integer> hourslist = FXCollections.observableArrayList();
        ObservableList<Integer> minuteandsecondlist = FXCollections.observableArrayList();
        for(int i=0;i<=60;i++)
        {
            if(i<=24)
            {
                hourslist.add(i);
            }
            minuteandsecondlist.add(i);
        }hours.setItems(hourslist);
        hours.setValue(0);

        minutes.setItems(minuteandsecondlist);
        minutes.setValue(0);

        seconds.setItems(minuteandsecondlist);
        seconds.setValue(0);
    }

    @FXML
    public void handleBackButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Stage window = (Stage)back.getScene().getWindow();
        window.setScene(new Scene(root, 1537, 810));
        window.setMaximized(true);
        window.getIcons().add(new Image("E:/College/Sem - " +
                "3/OOP/Innovative/new/Logo/LOGOicon" +
                ".PNG"));
    }
}
