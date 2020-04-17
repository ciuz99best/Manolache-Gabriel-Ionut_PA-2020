import java.sql.Statement;

public class Album {
    String id,artist_id,name;
    int releaseYear;
    int likes;
    Album(String id,String artist_id,String name,int releaseYear,int likes)
    {
        this.id=id;
        this.artist_id=artist_id;
        this.name=name;
        this.releaseYear=releaseYear;
        this.likes=likes;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setArtistId(String artist_id)
    {
        this.artist_id=artist_id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear=releaseYear;
    }
    public void setLikes(int likes)
    {
        this.likes=likes;
    }
    public String getId()
    {
        return id;
    }
    public String getArtistId()
    {
        return artist_id;
    }
    public String getName()
    {
        return name;
    }
    public int getReleaseYear()
    {
        return releaseYear;
    }
    public int getLikes()
    {
        return likes;
    }
    public void print()
    {
        System.out.println(id+" "+artist_id+" "+name+" "+releaseYear+" "+likes);
    }
    public boolean insertDB()
    {
        try {
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into albums (id,artist_id,name,release_year,likes) values(\""+id+"\",\""+artist_id+"\",\""+name+"\","+releaseYear+", "+likes+")");
            System.out.println("Album was succesfully inserted.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
