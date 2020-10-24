package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signupcontroller implements Initializable {

        @FXML
        private TextField SUsername;

        @FXML
        private PasswordField Spass;

        @FXML
        private PasswordField Srepass;

        @FXML
        private Button SignupButton;

        @FXML
        private Label Srespnse;

       @FXML
       private Button SBacltoLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SBacltoLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              gotoLoginscreen();
                SBacltoLogin.getScene().getWindow().hide();
            }
        });
        SignupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                signup();
            }
        });
    }

    private void signup(){
        if(!SUsername.getText().equals("") && !Spass.getText().equals("") && !Srepass.getText().equals("")) {

           if(Spass.getText().equals(Srepass.getText())) {

               datasource data = new datasource();
               User user = new User();
               user.setUsername(SUsername.getText());    //getting data from the textfields
               user.setPassword(Spass.getText());
               //creating instance of datasource
               if (data.open()) {                             //opening connection to database
                   System.out.println("database Connected");
                   if (!data.checkuser(user)) {
                       data.adduser(user);
                       Srespnse.setText("User Successfully registered");
                   }else{
                       System.out.println("user already exists");
                       Srespnse.setText("This username is taken");
                       data.close();
                   }}

                   }else{
               System.out.println("Passwords do not match");
               Srespnse.setText("Passwords do not match");
           }
    }else{
            Srespnse.setText("One of the fields is empty");
        }
}

public void gotoLoginscreen(){
    Stage Lstage=new Stage();
    Parent root = null;
    try {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Lstage.setTitle("Login");
    Lstage.setScene(new Scene(root, 600, 400));

    Lstage.show();
}
}

