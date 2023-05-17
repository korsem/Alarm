package com.example.alarm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerAlarm {
    @FXML
    private Button outButton;
    @FXML
    protected void outButtonClick(){
        Stage stage = (Stage) outButton.getScene().getWindow();

        // Close the stage
        stage.close();
    }
}
