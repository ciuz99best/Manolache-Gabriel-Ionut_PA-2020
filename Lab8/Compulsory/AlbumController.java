import java.sql.ResultSet;
import java.sql.Statement;

public class AlbumController {
    public static void create(String name, int artistId, int releaseYear){
        try {

            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into albums (name,artist_id,release_year) values(\""+name+"\","+artistId+","+releaseYear+")");
            System.out.println("Artist was succesfully inserted.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void findByArtist(int artistId){
        try {
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from albums where artist_id="+artistId+"");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ "  " + rs.getString(4));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
