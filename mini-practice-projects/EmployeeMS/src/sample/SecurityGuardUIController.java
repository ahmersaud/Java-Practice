package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Exceptions.HourlyrateTooLowException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SecurityGuardUIController implements Initializable {

    @FXML
    private TextField SecuritygID;

    @FXML
    private TextField SecuritygName;

    @FXML
    private TextField ShourlyRate;

    @FXML
    private TextField SareaAssigned;

    @FXML
    private Button AddSecurityGButton;

    @FXML
    private Button SviewButton;

    @FXML
    private Button SsaveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AddSecurityGButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addsecurityGtoarray();
            }
        });
        SviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewEmployees();
            }
        });
        SsaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save();
            }
        });

    }
    public void viewEmployees(){
        for(Employee employee:Employee.employeeList){

            System.out.println( employee.toString());

        }
    }

    public void addsecurityGtoarray(){
        if(!SecuritygID.getText().equals("") && !SecuritygName.getText().equals("") && !ShourlyRate.getText().equals("") && !SareaAssigned.getText().equals("")){
            SecurityGuard securityGuard;
            securityGuard = new SecurityGuard();
            securityGuard.setId(Integer.parseInt(SecuritygID.getText()));
            securityGuard.setName(SecuritygName.getText());
            try {
                securityGuard.setHourlyRate(Integer.parseInt(ShourlyRate.getText()));
            } catch (HourlyrateTooLowException e) {
                e.printStackTrace();
            }
            securityGuard.setAreaAssigned(SareaAssigned.getText());

            Employee.employeeList.add(securityGuard);


        }
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
}
