package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Exceptions.CourseRateTooLowException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LecturerUIController implements Initializable {

    @FXML
    private TextField LecturerID;

    @FXML
    private TextField LecturerName;

    @FXML
    private TextField LCourseRate;

    @FXML
    private TextField LPublications;

    @FXML
    private Button LAddButton;

    @FXML
    private Button LviewButton;

    @FXML
    private Button LsaveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LAddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addlecturertoarray();

            }
        });

        LviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            viewEmployees();
            }
        });

        LsaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save();
            }
        });
    }

    public void save(){
         String DB_Name="Employee.db";
         String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\92332\\Documents\\" + DB_Name;
         String LECTURER_TABLE="Lecturer";
         String SECURITYGUARD_TABLE="Securityguard";
         String COLUMN_ID="id";
         String COLUMN_NAME="name";
         String COLUMN_COURSERATE="courserate";
         String COLUMN_NOPUBLICATIONS="publications";
         String COLUMN_HOURLYRATE="hourlyrate";
         String COLUMN_AREAassigned="areaAssigned";

        Connection conn= null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement=conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS "+ LECTURER_TABLE+"("
                    +COLUMN_ID+ " integer,"
                    +COLUMN_NAME+" text,"
                    +COLUMN_COURSERATE+" integer,"
                    +COLUMN_NOPUBLICATIONS+" integer)");

            statement.execute("CREATE TABLE IF NOT EXISTS "+ LECTURER_TABLE+"("
                    +COLUMN_ID+ " integer,"
                    +COLUMN_NAME+" text,"
                    +COLUMN_HOURLYRATE+" integer,"
                    +COLUMN_AREAassigned+" text)");

            for(Employee employee:Employee.employeeList){
                if(employee.getClass().equals("class Lecturer")){
                    Lecturer lecturer=new Lecturer(employee);
                    statement.execute("INSERT INTO "+LECTURER_TABLE+"("+COLUMN_ID+","
                                                                          +COLUMN_NAME+","
                                                                          +COLUMN_COURSERATE+","
                                                                          +COLUMN_NOPUBLICATIONS+") " +
                                                                           "VALUES("+"'"+lecturer.getId()+
                                                                                 "'"+","+lecturer.getName()+
                                                                                 ","+"'"+lecturer.getCourseRate()+"'"+
                                                                                 ","+"'"+lecturer.getNoOfPublications()+"'"+")");



                }else{
                    SecurityGuard securityGuard=new SecurityGuard(employee);
                    statement.execute("INSERT INTO "+SECURITYGUARD_TABLE+"("+COLUMN_ID+","
                                                                                +COLUMN_NAME+","
                                                                                +COLUMN_HOURLYRATE+","
                                                                                 +COLUMN_AREAassigned+") " +
                                                                              "VALUES("+"'"+securityGuard.getId()+
                                                                                    "'"+","+securityGuard.getName()+
                                                                                    ","+"'"+securityGuard.getHourlyRate()+
                                                                                    "'"+","+"'"+securityGuard.getAreaAssigned()+"'"+")");


                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void viewEmployees(){
        for(Employee employee:Employee.employeeList){

               System.out.println( employee.toString());

        }
    }

    public void addlecturertoarray(){
        if(!LecturerID.getText().equals("") && !LecturerName.getText().equals("") && !LCourseRate.getText().equals("") && !LPublications.getText().equals("")){
            Lecturer lecturer=new Lecturer();
            lecturer.setId(Integer.parseInt(LecturerID.getText()));
            lecturer.setName(LecturerName.getText());
            try {
                lecturer.setCourseRate(Integer.parseInt(LCourseRate.getText()));
            } catch (CourseRateTooLowException e) {
                e.printStackTrace();
            }
            lecturer.setNoOfPublications(Integer.parseInt(LPublications.getText()));

            Employee.employeeList.add(lecturer);


        }
    }
}
