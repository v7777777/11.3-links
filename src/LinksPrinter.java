import java.util.Collections;
import java.util.TreeMap;
import java.util.Vector;

public class LinksPrinter {

    TreeMap<String, Integer> levels = new TreeMap<>();

    public void print(Vector<String> links) {

        Collections.sort(links);

        getLevel(links);

        printMap (links);


    }

    private void getLevel(Vector<String> links) {

        String previous = null;
        int level = 0;

        for (int i = 0; i < links.size(); i ++) {

            if (i == 0)
            { levels.put(links.get(i), level);
                previous = links.get(i);
                continue;
            }

            if (links.get(i).contains(previous))
            { level = level + 1;
                levels.put(links.get(i), level);
            }

            else {

                for (int j = (i - 2); j >=0; j--) {

                    if (links.get(i).contains(links.get(j)))
                    { level = levels.get(links.get(j)) + 1;
                        levels.put(links.get(i), level);
                        break;
                    }


                }

            }

            previous = links.get(i);

        }
    }

    private void printMap (Vector<String> links) {

        for (int i = 0; i < links.size(); i ++) {

            printSpace(levels.get(links.get(i)));
            System.out.println(links.get(i));
            Page.writer.write(links.get(i) + "\n");
            Page.writer.flush();

        }
    }

    private void printSpace(Integer level) {

        for (int s = 1; s <= level; s++) {

            System.out.print("\t");
            Page.writer.write("\t");
            Page.writer.flush();
        }


    }





}
























