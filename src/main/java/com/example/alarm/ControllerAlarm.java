package com.example.alarm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ControllerAlarm {
    @FXML
    private Button outButton;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Label percentageLabel;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private Label welcomeText;

    // button wyjscia
    @FXML
    protected void outButtonClick(){
        Stage stage = (Stage) outButton.getScene().getWindow();

        stage.close();
    }

    //button zapisu
    @FXML
    protected void saveButtonClick(){
        welcomeText.setText("zapisano");
    }

    public void initialize() {

        // konfiguracja slidera glosnosci
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double percentage = newValue.doubleValue() / volumeSlider.getMax() * 100;
            percentageLabel.setText(String.format("%.0f%%", percentage));
        });
        // konfiguracja spinera do godziny
        SpinnerValueFactory.IntegerSpinnerValueFactory hourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        hourSpinner.setValueFactory(hourFactory);

        // konfiguracja spinera do minuty
        SpinnerValueFactory.IntegerSpinnerValueFactory minuteFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        minuteSpinner.setValueFactory(minuteFactory);
    }

}
