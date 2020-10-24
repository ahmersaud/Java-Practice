package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }


    public static void main(String[] args) {


//        datasource data=new datasource();
//        if(data.open()){
//            System.out.println("database Connected");
//            User me=new User();
//            me.setUsername("Ahmer");
//            me.setPassword("mypass");
//            data.adduser(me);
//            List<User> users=new ArrayList<>();
//            users=data.queryUsers();
//            for(User user:users){
//                System.out.println("Username:"+user.getUsername()+" Password: "+user.getPassword());
//            }
//        }

        launch(args);

    }
}
