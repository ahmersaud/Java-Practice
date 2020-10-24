package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Label mylabel;
    TextField nametextfield;

    @Override
    public void start(Stage primaryStage) {
       primaryStage.setTitle("Hello Javafx");
        Button button=new Button();
        button.setText("Click me");
        mylabel=new Label();
        nametextfield=new TextField();
        nametextfield.setPromptText("Enter Your NAme");
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name=nametextfield.getText();
               mylabel.setText(name);
            }
        });


        FlowPane root=new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
//        StackPane root =new StackPane();


        root.getChildren().add(nametextfield);
        root.getChildren().add(mylabel);
        root.getChildren().add(button);
        Scene scene=new Scene(root,200,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}
