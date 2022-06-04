package com.temperatureconvertion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LogInController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Text message;


    @FXML
    void doLogIn(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();

        ArrayList<String[]> userData = getAllUserFromCSV();

        for (String[] data : userData) {
            if (data[0].equals(user) && data[1].equals(pass))
                switchToTemperatureConversion(event);
            else
                message.setText("Invalid username or password");
        }
    }

    void switchToTemperatureConversion(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("tempareture-view.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Temperature Conversion");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String[]> getAllUserFromCSV() {

        File file = new File("./src/user.csv");

        ArrayList<String[]> dataList = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                dataList.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dataList;
    }


}
