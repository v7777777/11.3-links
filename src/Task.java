import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;


public class Task extends RecursiveAction {

    private String link;

    public Task(String link)  {
        this.link = link;
        RootPage.getRootPage(link);  }

    private static ConcurrentHashMap<String, Integer> forVisitedLinks = new ConcurrentHashMap<>();
    public static Set<String> visitedLinks = forVisitedLinks.newKeySet();

    @Override
    protected void compute() {

        List<Task> taskList = new ArrayList<>();

        Document doc = null;

        try {
             Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {doc = Jsoup.connect(link).ignoreHttpErrors(true).timeout(0).get(); }

        catch (Exception e ) { e.printStackTrace();}

        Elements links = doc.select("a[href]");

        for(Element link : links) {

            String stringLink = link.attr("abs:href");

            if (stringLink.contains(RootPage.rootLink) & !visitedLinks.contains(stringLink)) {

                    if (stringLink.contains("#") || stringLink.contains(".jpg") || stringLink.contains(".png")) {continue;}

                    if (stringLink.contains(".pdf"))
                    {visitedLinks.add(stringLink);
                        continue;}

                    Task task = new Task(stringLink);
                    task.fork();
                    visitedLinks.add(stringLink);
                    taskList.add(task); }

        }

        for (Task task: taskList ) { task.join();}



    }



}



