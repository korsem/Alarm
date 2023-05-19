package com.example.alarm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Button outButton;
    @FXML Button newAlarmButton;

    @FXML
    protected void newAlarmButtonClick()  throws IOException{
        welcomeText.setText("dodaj alarm");
        Stage newAlarmStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("alarmView.fxml"));

        newAlarmStage.setTitle("Add New Alarm");

        Scene scene = new Scene(fxmlLoader.load(), 580, 450);

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