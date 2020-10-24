package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
    private Label title;
    private Label response;
    private Label selected;

    private CheckBox bananaCB;
    private CheckBox appleCB;
    private CheckBox mangoCB;
    private CheckBox orangeCB;
    private String fruits;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Favourite Fruit");

        title=new Label("What fruit do you like?");
        response=new Label("");
        selected=new Label("");

        bananaCB=new CheckBox("Banana");
        appleCB=new CheckBox("Apple");
        mangoCB=new CheckBox("Mango");
        orangeCB=new CheckBox("Orange");

    //set stage and scene
        FlowPane root=new FlowPane(Orientation.VERTICAL,5,5);
        root.setAlignment(Pos.CENTER);

        //this is where we add all our controls
        root.getChildren().addAll(title,bananaCB,appleCB,mangoCB,orangeCB,response,selected);

        Scene scene=new Scene(root,400,250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(Event event) {
        Object fruitchecked = event.getSource();
        if(bananaCB.equals(fruitchecked)){
            if(bananaCB.isSelected()){
                response.setText("Banana Selected");

            }
            else response.setText("Banana cleared");
        }
        if(appleCB.equals(fruitchecked)){
            if(appleCB.isSelected()){
                response.setText("Apple Selected");
            }
            else response.setText("Apple Cleared");
        }
        if(mangoCB.equals(fruitchecked)){
            if(mangoCB.isSelected()){
                response.setText("Mango Selected");
            }
            else response.setText("Mango Cleared");
        }
        if(orangeCB.equals(fruitchecked)){
            if(orangeCB.isSelected()){
                response.setText("Orange Selected");
            }
            else response.setText("Orange Cleared");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
