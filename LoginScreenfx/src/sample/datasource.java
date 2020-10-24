package sample;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class datasource {
    private String DB_NAME = "usercredentials.db";
    private String CONNECTION_STRING ="jdbc:sqlite:E:\\Java Practice Projects\\mini-practice-projects\\LoginScreenfx\\src\\sample\\database\\"+ DB_NAME;
    private Connection conn;
    public boolean open(){
        try{
             conn=DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }catch(SQLException e){
            System.out.println("Cant establish Connection"+ e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            System.out.println("Could'nt close the connection "+ e.getMessage());
        }
    }

    public boolean checkuser(User u) {
        boolean check = false;
        List<User> users=queryUsers();
        for (User user1 : users) {
                if (u.getUsername().equals(user1.getUsername())  ) {
                    System.out.println("User Exists");
                    check = true;
                    break;
                }}
        users.clear();

        return check;
    }
    public boolean checkpass(User u){
        boolean check = false;
        List<User> users=queryUsers();
        for (User user1 : users) {
            if (u.getPassword().equals(user1.getPassword())  ) {
                System.out.println("User Exists");
                check = true;
                break;
            }}
        users.clear();

        return check;

    }
    public void adduser(User u){
        if(!checkuser(u)){
            try(Statement statement=conn.createStatement();){
                statement.execute("INSERT INTO userdata(username,password) VALUES("+"'"+u.getUsername()+"'"+",'"+u.getPassword()+"')");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> queryUsers(){
        //method for retrieving all the users from database
        try(Statement statement=conn.createStatement();                                 //creating the Statement and ResultSet object inside try source
            ResultSet results=statement.executeQuery("SELECT * FROM userdata");)  // because it will automatically close them and we wont have to write the final block below
        {

            List<User> Users =new ArrayList<>(); //creating a list of type User  //main query
            while (results.next()){
                User user=new User();
                user.setUsername(results.getString("username"));
                user.setPassword(results.getString("password"));
                Users.add(user);
            }
            return Users;

        }
        catch(SQLException e){                                     //if something went wrong
            System.out.println("Query Failed "+e.getMessage());
            return null;
        }
    }}
