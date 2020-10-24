package com.company;

import model.Artist;
import model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource=new Datasource();
        if(!datasource.open()){
            System.out.println("Cant connect");
            return ;
        }
        List<Artist> artists=datasource.queryArtists();
        if(artists==null){
            System.out.println("No Artists found");
        }
        for(Artist artist:artists){
            System.out.println("id="+artist.getId()+", name="+artist.getName());
        }
        datasource.addArtist("KHANG");
        datasource.close();
    }
}
