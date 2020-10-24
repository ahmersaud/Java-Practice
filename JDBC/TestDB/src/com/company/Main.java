package com.company;

import java.sql.*;

public class Main {
    public static final String DB_Name="newdb.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\92332\\Documents\\" + DB_Name;
    public static final String TABLE_CONTACTS="contacts";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";

    public static void main(String[] args) {
       try{
        Connection conn= DriverManager.getConnection(CONNECTION_STRING);
        Statement statement=conn.createStatement();
       statement.execute("DROP TABLE IF EXISTS "+TABLE_CONTACTS );
        statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_CONTACTS+"("
                                                          +COLUMN_NAME+ " text,"
                                                          +COLUMN_PHONE+" integer,"
                                                          +COLUMN_EMAIL+" text)"); //creating a table 'contacts' if it does not exists in the db
           Insertcontact(statement,"Ali",3435234,"ali@email.com"); //calling function for inserting data
           Insertcontact(statement,"Saud",1234235,"saud@you.com");
      //  statement.execute("INSERT INTO contacts (name,phone,email) VALUES('Asad',12314234,'asad@email.com')");        //inserting values
      //  statement.execute("INSERT INTO contacts (name,phone,email) VALUES('KHAN',10090934,'khan12@email.com')");
//        statement.execute("UPDATE contacts SET phone=0987654 WHERE name='KHAN'"); //UPDATING values
//        statement.execute("DELETE FROM contacts WHERE name='Asad'"); //Deleting an entry from the table

           //now retrieving the values from the table
//          statement.execute("SELECT * FROM contacts");
//          ResultSet results=statement.getResultSet();     instead of these two lines
           ResultSet results=statement.executeQuery("SELECT * FROM contacts");// we can write this single line
          while(results.next()){
              System.out.println(results.getString("name")+" "
                                +results.getInt("phone")+" "
                                +results.getString("email"));
          }
          results.close();

          statement.close();
          conn.close();
       }
       catch (SQLException e){
           System.out.println("Something went wrong "+ e.getMessage());
           e.printStackTrace();
       }

    }

    public static void Insertcontact(Statement statement, String name,int phone, String email) throws SQLException {
        statement.execute("INSERT INTO "+TABLE_CONTACTS+"(name,phone,email) VALUES("+"'"+name+"'"+","+phone+","+"'"+email+"'"+")");
    }
}
