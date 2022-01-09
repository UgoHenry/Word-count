import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCountOccurrenceWithoutLambdasAndStream {
    public static void main(String[] args) throws FileNotFoundException {
//Opens file in read mode
// File path is passed as parameter
        String fileName = "C:\\Users\\Dell\\Desktop\\random story3.txt";
        Scanner input = new Scanner(new File(fileName));

        // counts word occurrences
        Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!wordCounts.containsKey(next)) {
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
//Getting all the entries of wordCounts in the form of Set
        Set<Map.Entry<String, Integer>> entrySet = wordCounts.entrySet();
//Creating a List by passing the entrySet
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
//Sorting the list in the decreasing order of values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return (e2.getValue().compareTo(e1.getValue()));
            }
        });
//Printing Words and number of their occurrences
        System.out.println("Words and number of their occurrences :");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() >= 1) {
                System.out.println("Words: " + entry.getKey() + "------>  Number of occurrence : " + entry.getValue());
            }
        }

    }
}
