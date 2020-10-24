package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller  {


    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private Label Result;

    @FXML
    private Button bequals;

    @FXML
    private Button bplus;

    @FXML
    private Button bminus;

    @FXML
    private Button bmultiply;

    @FXML
    private Button bdivide;

    @FXML
    private Label operator;

    @FXML
    private Button bC;

    @FXML
    private Button bans;

    @FXML
    private Label error;

    private float LastA;

    @FXML
    public void initialize() {
        bequals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             Float value1=null,value2=null,result = null;;

                try {
                 value1 = Float.parseFloat(textfield1.getText());
             }catch (NumberFormatException e ){
                 error.setText("Enter a valid number");
                 return;
             }
             try{
             value2=Float.parseFloat(textfield2.getText());}
             catch (NumberFormatException e ){
                 error.setText("Enter a valid number");
                 return;
             }



                switch(operator.getText()) {
                    case "x":
                    {   result=value1*value2;
                        LastA=result;
                        Result.setText(String.valueOf(result));
                        break;}
                    case "+":
                    {   result=value1+value2;
                        LastA=result;
                        Result.setText(String.valueOf(result));
                        break;}
                    case "-":
                    {   result=value1-value2;
                        LastA=result;
                        Result.setText(String.valueOf(result));
                        break;
                    }
                    case "/":
                    {   result=value1/value2;
                        LastA=result;
                        Result.setText(String.valueOf(result));
                        break;
                    }
                    default:{}

                }

            }
        });



        bplus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator.setText("+");
            }
        });

        bminus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator.setText("-");
            }
        });

        bdivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator.setText("/");
            }
        });

        bmultiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator.setText("x");
            }
        });

        bC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textfield1.setText("");
                textfield2.setText("");
                operator.setText("");
                Result.setText("");
                error.setText("");
            }
        });
        bans.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(textfield1.getText().equals("")&&textfield2.getText().equals("")){
                    textfield1.setText(String.valueOf(LastA));
                }else if(!textfield1.getText().equals("")&&textfield2.getText().equals("")){
                    textfield2.setText(String.valueOf(LastA));
                }else if(textfield1.getText().equals("")&&!textfield2.getText().equals("")){
                    textfield1.setText(String.valueOf(LastA));
                }
            }
        });
    }
}
