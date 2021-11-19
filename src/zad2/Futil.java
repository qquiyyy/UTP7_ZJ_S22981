package zad2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Futil {

    Futil(){
        //
    }


    public static void processDir(String dirName, String resultFileName) {
        Path rootDir = Paths.get(dirName); //ścieżka główna
        Path outputFile = Paths.get(resultFileName); //ścieżka outputu
        List<Path> filesToProcess = new ArrayList<>();

        for (String s: getAllFiles(rootDir)) {
            filesToProcess.add(Paths.get(s));
        }

        Charset charset = StandardCharsets.UTF_8;

        for (Path p: filesToProcess) {
            try {
                List<String> temp = Files.readAllLines(p, charset);
                Files.write(outputFile, temp, charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                //System.out.println("File "+ p + " processed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getAllFiles(Path path){
        try (Stream<Path> stream = Files.walk(path, Integer.MAX_VALUE)){
            List<String> collect = stream.map(String::valueOf).sorted().collect(Collectors.toList());
            collect.removeIf(s -> !s.endsWith(".txt"));
            return collect;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
