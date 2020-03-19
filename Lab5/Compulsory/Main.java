import java.util.*;
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Document article1=new Document();
        article1.setID("3523");
        article1.setName("COVID-19");
        article1.addTag("Pages","200");
        article1.addTag("Chaptes","Five");
        article1.addTag("Color","Red");
        Document book1=new Document();
        book1.setID("35634");
        book1.setName("Basme");
        book1.addTag("Writer","Eminescu Mihai");
        book1.addTag("Pages","500");
        book1.addTag("Chaptes","Two");
        book1.addTag("Color","Black");
        Catalog catalog=new Catalog();
        catalog.addDocument(article1);
        catalog.addDocument(book1);
        catalog.printDocuments();
        CatalogController catalogController=new CatalogController();
        catalogController.setCatalog(catalog);
        catalogController.save("lemne.txt");
        Catalog newCatalog=new Catalog();
        catalogController.setCatalog(newCatalog);
        catalogController.load("lemne.txt");
        catalogController.print();
        //catalogController.view("lemne.txt");


    }
}
