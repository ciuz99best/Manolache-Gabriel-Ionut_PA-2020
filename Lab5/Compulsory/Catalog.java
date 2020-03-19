import java.util.*;
import java.io.*;

/**
 * public void addDocument(Document newDocument) - adds a new document to the documents list from the catalog
 *
 * public void removeDocument(Document oldDocument) - removes a document from the list of the current catalog
 *
 * public void printDocuments() - prints on the console the current all the documents information and details
 */
public class Catalog  implements java.io.Serializable{
    private List<Document> documents;
    Catalog()
    {
        documents=new ArrayList<Document>();
    }
    public void addDocument(Document newDocument)
    {
        documents.add(newDocument);
    }
    public void removeDocument(Document oldDocument)
    {
        documents.remove(oldDocument);
    }
    public void printDocuments()
    {
        for(int i=0;i<documents.size();i++)
        {
            System.out.println("ID: "+documents.get(i).getID()+"\nName: "+documents.get(i).getName()+"\nTags:");
            documents.get(i).printTags();
        }
    }

}
