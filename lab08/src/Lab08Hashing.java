import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Lab08Hashing {

    public static void main(String[] args) throws Exception {

        int lineNum = 0;

        BufferedReader reader = new BufferedReader(new FileReader("C:\\hmw\\C343samtanne\\labs\\lab08\\src\\text.txt"));

        Map<String, String> frequency = new HashMap<>();

        String line = reader.readLine();
        while(line != null) {
            lineNum++;
            System.out.println("Processing line: "+lineNum+" " + line);

            if(!line.trim().equals("")) {
                String [] words = line.split(" ");

                for(String word : words) {
                    if(word == null || word.trim().equals("")) {
                        continue;
                    }
                    String processed = word.toLowerCase();
                    processed = processed.replace(",", "");
                    if(frequency.containsKey(processed)) {
                        frequency.put(processed,
                                frequency.get(processed) + "["+lineNum+"] ");
                    } else {
                        frequency.put(processed, "["+lineNum+"] ");
                    }
                }
            }

            line = reader.readLine();
        }
        String word1 = "data";
        String word2 = "that";
        String word3 = "dingus";

        System.out.println(frequency);



        System.out.println();
        for (Map.Entry<String, String> entry : frequency.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if( key.contentEquals(word1) ||key.contentEquals(word2)||key.contentEquals(word3)){
                System.out.println(key + value);
            }

        }

    }

}