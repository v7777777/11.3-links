public class RootPage {

    public static volatile String rootLink;  // null если вызвать до вызова getRootPage() до создания Page

    private static RootPage rootPage;

    private RootPage(String root) {
        this.rootLink = root;
    }

    public static RootPage getRootPage(String rootLink) {

        if (rootPage == null) {
            synchronized (RootPage.class)
            {
                if (rootPage == null) {rootPage = new RootPage(rootLink);}

            }
            return rootPage; }

        else {
            return rootPage;
        }

    }




}