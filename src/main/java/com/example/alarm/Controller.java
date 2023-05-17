package com.example.alarm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Button outButton;
    @FXML Button newAlarmButton;

    @FXML
    protected void newAlarmButtonClick() {
        welcomeText.setText("dodaj alarm");
        Stage newAlarmStage = new Stage();
        newAlarmStage.setTitle("Add New Alarm");

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("alarmView.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 380, 420); // height / width

//        stage.setTitle("Alarm");
//        stage.setScene(scene);
        newAlarmStage.show();
    }
    @FXML
    protected void outButtonClick(){
        Stage stage = (Stage) outButton.getScene().getWindow();

        // Close the stage
        stage.close();
    }
}