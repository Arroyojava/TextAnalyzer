/*
    Jordan Arroyo
    Date: 09/03/2022
    Purpose: Write a text analyzer that reads a file and outputs statistics about that file.
    It should output the word frequencies of all words in the file, sorted by the most frequently used word.
    The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 */
package analyzer;


import java.io.*;
import java.util.*;

import static java.lang.System.out;
import static analyzer.QuickSort.quickSort;

public class TextAnalyzer {
    public static void main(String[] args) throws IOException {

        File macBeth = new File("src\\analyzer\\macbeth.txt");

        List<String> words = getAllWords(macBeth);

        quickSort(words, 0, words.size() - 1);

        out.print(frequency(words));


    }

    public static HashMap<String, Integer> frequency(List<String> list) {

        HashMap<String, Integer> freq = new HashMap<>();
        int count = 1;

        for (String str : list){
            if (freq.containsKey(str)){
                freq.computeIfPresent(str, (key, value) -> value + value);
            }
            else
                count = 0;
            freq.put(str, count);

        }

        return freq;
    }

    public static List<String> getAllWords(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);

        //List to store words
        List<String> allWords = new ArrayList<>();

        String word;
        //Scan for words and remove all punctuation
        while (scan.hasNext()) {
            word = scan.next().toLowerCase().replaceAll("\\p{Punct}", "");
            allWords.add(word);
        }
        return allWords;
    }
}
