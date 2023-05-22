package com.example.alarm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.example.alarm.Controller;



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

    ArrayList<Alarm> savedAlarms = new ArrayList<>(); //lista zapisanych budzikow

    private Controller controller;
    public void setController(Controller controller) {
        this.controller = controller;
    }

    // button wyjscia
    @FXML
    protected void outButtonClick(){
        Stage stage = (Stage) outButton.getScene().getWindow();

        stage.close();
    }

    //button zapisu
    @FXML
    protected void saveButtonClick() throws InterruptedException {
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

        // dodaje do mojej listy budzikow
        savedAlarms.add(alarm);

        // zmiana labela w drugim oknie
        if (controller != null) {
            controller.updateActiveAlarmsText(alarm.toString() + "\n");
        }

        welcomeText.setText("Zapisano: " + alarm.getAlarmName()); // komunikat o zapisie

        // chce zeby wyswietlilo mi nazwe budzika ktory zostal zapisany zanim sie zamknie
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            Stage stage = (Stage) outButton.getScene().getWindow();
            stage.close();
        });
        delay.play();
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
