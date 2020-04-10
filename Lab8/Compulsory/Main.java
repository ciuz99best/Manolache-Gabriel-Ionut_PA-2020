import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance( );
        ArtistController.create("Eminescu","Iasi");
        ArtistController.create("Ion","Humulesti");
        ArtistController.create("Caragiale","Vaslui");
        ArtistController.findByName("Ion");
        AlbumController.create("AlbumUnu",2 ,2120);
        AlbumController.create("AlbumDoi",2,2120);
        AlbumController.create("AlbumTrei",3 ,2120);
        AlbumController.create("AlbumPatru",1 ,2120);
        AlbumController.create("AlbumCinci",2 ,2120);
        AlbumController.findByArtist(2);
    }
}
