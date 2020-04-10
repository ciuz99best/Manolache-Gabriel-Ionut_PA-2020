import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistController {
    public static void create(String name, String country){
        try {

            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into artists (name,country) values(\""+name+"\",\""+country+"\")");
            System.out.println("Artist was succesfully inserted.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void findByName(String name){
        try {
            Statement stmt = Database.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from artists where name=\""+name+"\";");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
