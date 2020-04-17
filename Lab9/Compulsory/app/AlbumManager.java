/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ciuzb
 */
import com.github.javafaker.Faker;


public class AlbumManager{
    public static void main(String[] args) {
        Database db = Database.getInstance( );
        Faker faker=new Faker();
        try {
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("drop table if exists chartpositions,albums,charts,artists");
            stmt.executeUpdate("create table Artists(id varchar(12) primary key,name varchar(100),country varchar(100))");
            System.out.println("Table Artists created.");
            stmt.executeUpdate("create table Albums(id varchar(12) primary key,artist_id varchar(12),name varchar(100),release_year int,likes int,foreign key (artist_id) references Artists(id))");
            System.out.println("Table Albums created.");
            stmt.executeUpdate("create table Charts(id varchar(12) primary key,name varchar(100))");
            System.out.println("Table Charts created.");
            stmt.executeUpdate("create table ChartPositions(album_id varchar(12),chart_id varchar(12),position int,primary key (album_id,chart_id),foreign key(album_id) references Albums(id),foreign key (chart_id) references Charts(id), unique key position (position,chart_id))");
            System.out.println("Table Artists created.");
        } catch (Exception e) {
            System.out.println(e);
        }


        List<Artist> artistList=new ArrayList<Artist>();
        List<Album> albumList=new ArrayList<Album>();
        List<Chart> chartList=new ArrayList<Chart>();
        int artists_number=100,albums_number=50,charts_number=5;

        for(int i=0;i<artists_number;i++)
        {
            boolean ok;
            Artist tmp;
            do {
                tmp=new Artist(faker.idNumber().valid(), faker.name().fullName(), faker.address().country());
                ok=tmp.insertDB();
            }while(!ok);
            artistList.add(tmp);
        }
        Random rand=new Random();
        for(int i=0,j=rand.nextInt(artists_number);i<albums_number;i++,j=rand.nextInt(artists_number))
        {
            boolean ok;
            Album tmp;
            do {
                tmp=new Album(faker.idNumber().valid(),artistList.at(j).getId(),faker.book().title(),1950+rand.nextInt(70),rand.nextInt(1000000));
                ok=tmp.insertDB();
            }while(!ok);
            albumList.add(tmp);
        }
        for(int i=0;i<charts_number;i++)
        {
            boolean ok;
            Chart tmp;
            do {
                tmp=new Chart(faker.idNumber().valid(),"Top"+faker.music().genre());
                ok=tmp.insertDB();
            }while(!ok);
            chartList.add(tmp);
            int number_of_albums_in_chart=rand.nextInt(20);
            for(int j=0;j<number_of_albums_in_chart;j++)
            {
                while(!ChartPositions.insertDB(albumList.at(rand.nextInt(albums_number)).getId(),chartList.at(i).getId(),rand.nextInt(number_of_albums_in_chart)+1));
            }
        }
        try {
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT artists.name from artists join albums on albums.artist_id=artists.id join chartpositions on chartpositions.album_id=albums.id join charts on charts.id=chartpositions.chart_id order by position asc");
            int i=1;
            while (rs.next())
                System.out.println((i++)+". "+rs.getString(1));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
