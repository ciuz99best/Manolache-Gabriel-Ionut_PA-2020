import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Chart {
    String id,name;
    List<Album> albums;
    Chart(String id,String name)
    {
        this.name=name;
        this.id=id;
        albums=new ArrayList<Album>();
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public String getId()
    {
        return id;
    }
    public void addAlbum(Album album)
    {
        albums.add(album);
    }
    public void print()
    {
        for(int i=0;i<albums.size();i++){
            System.out.print((i+1)+". ");
            albums.get(i).print();}
    }
    public boolean insertDB()
    {
        try {
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into charts (id,name) values(\""+id+"\",\""+name+"\")");
            System.out.println("Album was succesfully inserted.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
