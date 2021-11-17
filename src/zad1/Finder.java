/**
 *
 *  @author Zaręba Jakub S22981
 *
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Finder {

    private ArrayList<String> stringList = new ArrayList<>();
    private Map<String, Integer> hMap = new HashMap<>();

    Finder(String file){
        try {
            Scanner in = new Scanner(new File(file));
            while (in.hasNextLine()){
                stringList.add(in.nextLine());
            }
            in.close();

            this.hMap = countFrequencies(stringList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int getIfCount() {


        return hMap.get("if");
    }

    public int getStringCount(String str) {
        return hMap.get(str);
    }

    private Map<String, Integer> countFrequencies(ArrayList<String> list)
    {
        // hashmap to store the frequency of element
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

       /* // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }*/

        return hm;
    }
}
