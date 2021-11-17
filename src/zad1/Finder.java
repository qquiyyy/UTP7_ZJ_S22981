/**
 *
 *  @author Zaręba Jakub S22981
 *
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//            this.hMap = countFrequencies(stringList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int getIfCount() {
        int counter = 0;
        Pattern p = Pattern.compile("(?:^|\\}\\s*else)\\s+if",Pattern.MULTILINE);

        boolean b = false;
        //zakładamy że nie ma więcej niż jednego if'a w linii
        for (String s: this.stringList) {
            if (s.startsWith("//"))
                continue;
            if (s.contains("/*")||b) //niezbyt ładnie ale raczej działa
            {
                b=true;
                if (s.endsWith("*/"))
                {
                    b=false;
                    continue;
                }else continue;
            }else {
                Matcher m = p.matcher(s);
                if (m.find()) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int getStringCount(String str) {
        int counter = 0;
        boolean b = false;
        for (String s: stringList
             ) {
            if (s.startsWith("//"))
                continue;
            if (s.contains("/*")||b) //niezbyt ładnie ale raczej działa
            {
                b=true;
                if (s.endsWith("*/"))
                {
                    b=false;
                    continue;
                }else continue;
            }else if (s.contains("wariant"))
                counter++;

        }
        return counter;
    }
}
