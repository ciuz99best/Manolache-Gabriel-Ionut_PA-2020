import java.sql.Statement;

public class Artist {
    String id,name,country;
    Artist(String id,String name,String country)
    {
        this.id=id;
        this.name=name;
        this.country=country;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setCountry(String country)
    {
        this.country=country;
    }
    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getCountry()
    {
        return country;
    }
    public void print()
    {
        System.out.println(id+" "+name+" "+country);
    }
    public boolean insertDB()
    {
        try {
            Statement stmt = Database.getConnection().createStatement();
            stmt.executeUpdate("insert into artists (id,name,country) values(\""+id+"\",\""+name+"\",\""+country+"\")");
            System.out.println("Artist was succesfully inserted.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
