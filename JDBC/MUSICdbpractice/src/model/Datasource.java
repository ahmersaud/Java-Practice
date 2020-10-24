package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME="music.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\92332\\Documents\\MUSICdbpractice\\"+DB_NAME;

    public static final String TABLE_ALBUMS="albums";
    public static final String COLUMN_ALBUMS_ID="id";
    public static final String COLUMN_ALBUMS_NAME="name";
    public static final String COLUMN_ALBUMS_ARTIST="artist";

    public static final String TABLE_ARTISTS="artists";
    public static final String COLUMN_ARTISTS_ID="id";
    public static final String COLUMN_ARTISTS_NAME="name";

    public static final String TABLE_SONGS="songs";
    public static final String COLUMN_SONGS_ID="id";
    public static final String COLUMN_SONGS_TRACK="track";
    public static final String COLUMN_SONGS_TITLE="title";
    public static final String COLUMN_SONGS_ALBUM="album";

    private Connection conn;

    public boolean open(){                                                //method for opening a connection
        try{
            conn= DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }
        catch(SQLException e){
            System.out.println("Could'nt connect "+e.getMessage());
            return false;
        }

    }

    public void close(){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            System.out.println("Could'nt close the connecton "+ e.getMessage());
        }
    }

    public void addArtist(String name){
        try(Statement statement=conn.createStatement();
            ResultSet results=statement.executeQuery("SELECT * FROM "+TABLE_ARTISTS)){
            List<String> Anames=new ArrayList<>();
            String an;
            while(results.next()){
                an=results.getString(COLUMN_ARTISTS_NAME);
                Anames.add(an);
            }
            boolean checkartist = false;
            for (String aname : Anames) {
                if (name.equals(aname)) {
                    System.out.println("Artist Already Exists");
                    checkartist = true;
                    break;
                }
            }
          if(!checkartist){
              statement.execute("INSERT INTO "+TABLE_ARTISTS+"(name) VALUES("+"'"+name+"'"+")");

          }
        }

            catch (SQLException e){

        }
    }

    public List<Artist> queryArtists(){
        //method for retrieving all the artists from database
        try(Statement statement=conn.createStatement();                                 //creating the Statement and ResultSet object inside try source
        ResultSet results=statement.executeQuery("SELECT * FROM "+TABLE_ARTISTS);)  // because it will automatically close them and we wont have to write the final block below
        {

        List<Artist> artists =new ArrayList<>(); //creating a list of type Artist  //main query
        while (results.next()){
            Artist artist=new Artist();
            artist.setId(results.getInt(COLUMN_ARTISTS_ID));
            artist.setName(results.getString(COLUMN_ARTISTS_NAME));
            artists.add(artist);
        }
        return artists;

        }
        catch(SQLException e){                                     //if something went wrong
            System.out.println("Query Failed "+e.getMessage());
            return null;
        }
        //no need to write this block,reason mentioned above at try block
//        finally {                                                 //recovering from a worst case scenario
//            try{
//                if(results!=null){
//                    results.close();
//                }
//            }catch(SQLException e){
//                System.out.println("Cant close results "+e.getMessage());
//            }
//            try{
//                if(statement!=null){
//                    statement.close();
//                }
//            }catch(SQLException e ){
//                System.out.println("cant close "+e.getMessage());
//            }
//        }

    }
}
