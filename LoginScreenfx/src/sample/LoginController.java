package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private    TextField LoginUsername;

    @FXML
    private  PasswordField LoginPassword;

    @FXML
    private Button LoginButton;
    @FXML
    private Label response;

    @FXML
    private Button signupbutton;

//    private static String Lusername;

//    public static String getloginusername(){
//
//        return Lusername;
//    }
//    private void setloginusername(String u){
//
//        Lusername=u;
//    }


    @FXML
    void initialize() {
    User me= new User();
        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login Button Clicked");
                loginUser();
            }
        });

        signupbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           gotoSignup();
            }
        });

    }

    private void gotoSignup(){
        LoginButton.getScene().getWindow().hide();
        Stage signupstage=new Stage();
        try {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("signup.fxml"));
            Parent root = loader.load();



            Scene scene = new Scene(root);

            signupstage.setScene(scene);
            signupstage.setTitle("Signup");
            signupstage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginUser(){


        if(!LoginUsername.getText().equals("") || !LoginPassword.getText().equals("")) {

            User user = new User();
            user.setUsername(LoginUsername.getText());    //getting data from the textfields
            user.setPassword(LoginPassword.getText());

            datasource data = new datasource();    //creating instance of datasource

            if (data.open()) {                             //opening connection to database
                System.out.println("database Connected");
                if (data.checkuser(user)) {                //checing if the user exists
                    if (data.checkpass(user)) {//checking if the password is correct



                        LoginButton.getScene().getWindow().hide();  //hiding the login window,stage
                        Stage Detailstage = new Stage();          //creating the details window,stage
                        try {
                            FXMLLoader loader = new  FXMLLoader(getClass().getResource("details.fxml"));
                            Parent root = loader.load();



                            Scene scene = new Scene(root);

                            Detailstage.setScene(scene);
                            Detailstage.setTitle("Details");
                            Detailstage.show();



                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        response.setText("Incorrect password");
                    }

                } else {
                    response.setText("User not found");
                }


            }
        }


    }
}

