package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.scene.layout.BorderPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        // Scene name
        stage.setTitle("Regex Checker");

        // Components
        VBox vbox = new VBox();
        Label regexLabel = new Label("Please Enter regex expression");
        TextArea regexArea = new TextArea();
        Label textLabel = new Label("Please enter text");
        TextArea textArea = new TextArea();
        Button button = new Button("Check Regex");

        // Button Behaviour
        button.setOnAction(e -> {
            String inputRegex = regexArea.getText();
            String inputPattern = textArea.getText();

            Pattern pattern = Pattern.compile(inputRegex);
            Matcher matcher = pattern.matcher(inputPattern);
            boolean result = matcher.find();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (result){
                alert.setContentText("Gut");
            } else
            {
                alert.setContentText("Not gut");
            }
            alert.showAndWait();
        });

        // Add Components into VBox
        vbox.getChildren().addAll(textLabel, textArea, regexLabel, regexArea, button);

        // Create pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);

        // Add scene
        Scene scene = new Scene(borderPane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}