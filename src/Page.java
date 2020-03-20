import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;


public class Page {

    private static final String FILE = "links.txt";

    private String link;

    public static volatile File file = new File(FILE); // нужен volatile ??

    public static PrintWriter writer;


    static {
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Page> children = new ArrayList<>();

    public static Vector<String> allLinks = new Vector<>();

    public static Vector<String> visitedLinks = new Vector<>();

    public Page (String link)  {

        this.link =link;
            if (!file.exists()) {file.mkdir();}

        RootPage.getRootPage(link);  // <---- нужно 1 раз но будет возвращаться каждый раз при создании Page?

       }



    public ArrayList<Page> getChildren() {return children; }

    public String getLink(){return link;}

    public static Vector<String> getAllLinks() {
        return allLinks;
    }
}




