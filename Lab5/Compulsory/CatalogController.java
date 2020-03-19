import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * public void save(String filePath) - opens the file from filePath and then saves the current catalog to the file
 * * if there are any problems within the process a exeption is thrown
 *
 * public void load(String filePath) - opens the file from filePath and then loads the object from the file to the catalog from this class
 *  * if there are any problems within the process a exeption is thrown
 *
 * public void view(String filePath) - opens the file from filePath in the Desktop with the default application
 * * if there are any problems within the process a exeption is thrown
 */
public class CatalogController{
    public Catalog catalog;
    CatalogController()
    {
        catalog=new Catalog();
    }
    public void setCatalog(Catalog newCatalog)
    {
        catalog=newCatalog;
    }
    public void save(String filePath)
    {
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(catalog);
            out.close();
            file.close();
            System.out.println("Object has been saved!");

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }
    }
    public void load(String filePath)
    {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            catalog = (Catalog)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been loaded!");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }
    public void view(String filePath)
    {
        try
        {
            File file=new File(filePath);
            Desktop.getDesktop().open(file);
            System.out.println("Object has been opened!");

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }
    }
    public void print()
    {
        catalog.printDocuments();
    }
}
