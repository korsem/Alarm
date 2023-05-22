package com.example.alarm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.alarm.ControllerAlarm;

import java.io.IOException;
public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Button outButton;
    @FXML Button newAlarmButton;
    @FXML
    public Label activeAlarms;

    public Label getActiveAlarms() {
        return activeAlarms;
    }

    public void updateActiveAlarmsText(String text) {
        activeAlarms.setText(activeAlarms.getText()+text);
    }
    @FXML
    protected void newAlarmButtonClick()  throws IOException{
            welcomeText.setText("dodaj alarm");

            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("alarmView.fxml"));
            Parent alarmView = fxmlLoader.load();

            // ustawiam controller do którego odwołuhe się w ControllerAlarm aby zmienic dodane alarmy
            ControllerAlarm controllerAlarm = fxmlLoader.getController();
            controllerAlarm.setController(this);

            Stage newAlarmStage = new Stage();
            newAlarmStage.setTitle("Add New Alarm");
            Scene scene = new Scene(alarmView, 580, 450);
            newAlarmStage.setScene(scene);
            newAlarmStage.setResizable(false);
            newAlarmStage.show();
        }
    @FXML
    protected void outButtonClick(){
        Stage stage = (Stage) outButton.getScene().getWindow();

        // zamkniecie stagea
        stage.close();
    }

}