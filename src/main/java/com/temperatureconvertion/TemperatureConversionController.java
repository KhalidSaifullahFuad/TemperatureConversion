package com.temperatureconvertion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TemperatureConversionController {

    @FXML
    private Button btnConvert;

    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    public static String[] csvHeader = new String[]{"Celsius", "Fahrenheit", "Kelvin"};

    @FXML
    void doConvert(ActionEvent event) {
        String inputValue = input.getText();

        double fahrenheit = Double.parseDouble(inputValue);
        double celsius = (fahrenheit - 32) * 5 / 9;
        double kelvin = celsius + 273.15;
        double rankine = (celsius + 273.15) * 1.8;

        output.setText(String.format("Kelvin: %.2f\nCelsius: %.2f\nRankine: %.2f\n", kelvin, celsius, rankine));

        // Append result to CSV file
        writeCSVToFile(new String[]{celsius + "", fahrenheit + "", kelvin + ""});
    }


    public static void writeCSVToFile(String[] data) {
        File file = new File("./Text.csv");

        try (PrintWriter writer = new PrintWriter(file)) {
            if(file.length() == 0) writer.append(String.join(",", csvHeader)).append("\n");
            writer.append(String.join(",", data)).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
