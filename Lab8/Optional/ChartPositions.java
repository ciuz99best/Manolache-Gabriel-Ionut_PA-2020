import java.sql.Statement;

public class ChartPositions {
    public static boolean insertDB(String album_id,String chart_id,int position)
    {
        try {
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into ChartPositions (album_id,chart_id,position) values(\""+album_id+"\",\""+chart_id+"\","+position+")");
            System.out.println("Chart entry was succesfully inserted.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
