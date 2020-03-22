
import java.io.IOException;

import java.util.concurrent.ForkJoinPool;


public class Main {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool =  new ForkJoinPool();

        forkJoinPool.invoke(new Task("https://skillbox.ru/")); //  http://sendel.ru   https://skillbox.ru/

        System.out.println("Link printer");

        LinksPrinter linksPrinter = new LinksPrinter();

        linksPrinter.print(Task.visitedLinks);

        long stop = System.currentTimeMillis();

        System.out.println(stop-start + " ms " );


    }


}


