import java.util.*;

/**
 * public void addTag(String newTag,String value) - adds a tag to a hashmap of tags for a document
 *
 * public void replaceTag(String tag,String newValue) - replaces the tag value from the hashmap of documents
 *
 * public void printTags() - prints all the tags from the hashmap that the document contains
 */
public class Document implements java.io.Serializable{
    private String ID;
    private String name;
    private Map<String,String> tags;
    Document()
    {
        ID=new String();
        name=new String();
        tags=new HashMap<String,String>();
    }
    public void setID (String newID)
    {
        ID=newID;
    }
    public String getID()
    {
        return ID;
    }
    public void setName(String newName)
    {
        name=newName;
    }
    public String getName()
    {
        return name;
    }
    public void addTag(String newTag,String value)
    {
        tags.put(newTag,value);
    }
    public void replaceTag(String tag,String newValue)
    {
        tags.replace(tag,tags.get(tag),newValue);
    }
    public void printTags()
    {
        for(String key: tags.keySet())
        {
            System.out.println("  "+key+"- "+tags.get(key));
        }
    }
}
