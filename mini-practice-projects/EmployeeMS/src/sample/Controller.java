package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

        @FXML
        private
        Button LecturerButton;

        @FXML
        private Button SecurityGuardButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LecturerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openLecturerUI();

            }
        });
        SecurityGuardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openSecurityguardUI();

            }
        });
    }

    public void openSecurityguardUI()  {
        SecurityGuardButton.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SecurityGuardUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage SGstage=new Stage();
        SGstage.setTitle("Add Security Guard");
        SGstage.setScene(new Scene(root, 600, 400));
        SGstage.show();
    }
    public void openLecturerUI(){
        LecturerButton.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LecturerUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage Lstage=new Stage();
        Lstage.setTitle("Add Lecturer");
        Lstage.setScene(new Scene(root, 600, 400));
        Lstage.show();
    }
}

