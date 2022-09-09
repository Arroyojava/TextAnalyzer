/*
    Jordan Arroyo
    Date: 09/03/2022
    Purpose: Write a text analyzer that reads a file and outputs statistics about that file.
    It should output the word frequencies of all words in the file, sorted by the most frequently used word.
    The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 */
package analyzer;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class TextAnalyzer {
    public static void main(String[] args) throws IOException {

        File macBeth = new File("src\\analyzer\\macbeth.txt");

        List<String> words = getAllWords(macBeth);

        HashMap<String, Integer> map = frequencyMap(words);

        topTwenty(map);

    }

    //Method to print top 20 words used in file
    public static void topTwenty(HashMap<String, Integer> map) {

        //Create new list to store hashmap values
        List<Integer> newList = new ArrayList<>();
        for (Map.Entry<String, Integer> val : map.entrySet()) {
            newList.add(val.getValue());
        }

        //Sort Values in desc order
        newList.sort(Collections.reverseOrder());

        //Modify newList to a sublist containing top 20 values from hashmap
        newList = newList.subList(0, 20);

        //Loop through Hashmap and newList to find values matching key and print pairs
        for (Integer value : newList) {
            for (String key : map.keySet()) {
                if (Objects.equals(map.get(key), value))
                    out.println("\"" + key.toUpperCase() + "\" occurs " + value + " times.");
            }
        }
    }

    //Method to that returns Hashmap of words and how many times they are called, returns hashmap
    public static HashMap<String, Integer> frequencyMap(List<String> list) {

        HashMap<String, Integer> freq = new HashMap<>();

        for (String str : list) {
            Integer j = freq.get(str);
            freq.put(str, (j == null) ? 1 : j + 1);
        }
        return freq;
    }

    //Method that scans file, removes punctuation and returns list or words
    public static List<String> getAllWords(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        //List to store words
        List<String> allWords = new ArrayList<>();

        //Scan for words, remove all punctuation and adds word to list to return
        String word;
        while (scan.hasNext()) {
            word = scan.next().toLowerCase().replaceAll("\\p{Punct}|\\s", "");
            allWords.add(word);
        }
        return allWords;
    }
}
