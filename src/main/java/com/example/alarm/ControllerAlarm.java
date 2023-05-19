package com.example.alarm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

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

    @FXML
    private TextField nameTextField;

    @FXML
    private CheckBox repeatingCheckBox;
    @FXML
    private CheckBox mon, tue, wen, thu, fri, sat, sun;

    private String alarmName;
    private boolean[] weekDays = new boolean[7];

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
        String alarmName = nameTextField.getText(); // pobiera nazwe budzika z pola tekstowego
        int hour = hourSpinner.getValue(); // pobiera godzie ze spinnera
        int minute = minuteSpinner.getValue(); // pobiera godzine ze spinnera
        double volume = volumeSlider.getValue(); // pobiera głośnosc z suwaka
        boolean weekly = repeatingCheckBox.isSelected(); // pobiera wartosc czy sie powtarza

        //pobiera wartosci z dni tygodnia
        weekDays[0] = mon.isSelected();
        weekDays[1] = tue.isSelected();
        weekDays[2] = wen.isSelected();
        weekDays[3] = thu.isSelected();
        weekDays[4] = fri.isSelected();
        weekDays[5] = sat.isSelected();
        weekDays[6] = sun.isSelected();

        // tworze nowy alarm
        Alarm alarm = new Alarm(alarmName, hour, minute, volume, weekly, weekDays);

        // tu musze liste budzikow zrobic

        welcomeText.setText("Zapisano: " + alarm.getAlarmName()); // komunikat o zapisie
        System.out.println(alarm.toString());
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

        // konfiguracja pola tekstowego nazwy
        nameTextField.setText("new alarm");

        // nasluchiwanie zdarzen
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            alarmName = newValue;
        });

        // konfiguracja CheckBoxa "czy co tydzien?"
        repeatingCheckBox.setSelected(false);

        // konfiguracja dni tygodnia
        mon.setSelected(false);
        tue.setSelected(false);
        wen.setSelected(false);
        thu.setSelected(false);
        fri.setSelected(false);
        sat.setSelected(false);
        sun.setSelected(false);

    }
}
