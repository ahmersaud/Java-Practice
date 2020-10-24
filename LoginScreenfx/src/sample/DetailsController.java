package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;






    public class DetailsController implements Initializable {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label detailusername;

        @FXML
        public void initialize(){

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            System.out.println("init 1");
//             detailusername.setText(LoginController.getloginusername());
        }

        public void setDusername(String u){
            detailusername.setText(u);
        }
    }


