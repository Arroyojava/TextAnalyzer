/* Author: Jordan Arroyo
 * Date: 4/15/2022
 * Purpose: Implement a standard Java algorithm using pseudocode.
 * 			Implemented QuickSort algorithm using Generics
 * Wiki Link: https://en.wikipedia.org/wiki/Quicksort
 * Filename: Quicksort_Algorithm.java
 */
package analyzer;

import java.util.List;

public class QuickSort {
    static <E extends Comparable<E>> void quickSort(List<E> list, int start, int end) {

        // Base Case
        if (start > end || list.size() < 2) {
            return;
        }

        int pivot = partition(list, start, end);

        // Recursive quickSort call with pivot
        quickSort(list, start, pivot - 1);
        quickSort(list, pivot + 1, end);
    }

    private static <E extends Comparable<E>> int partition(List<E> list, int start, int end) {

        // Set pivot point to end of list
        E pivot = list.get(end);
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                varSwap(list, i, j);
            }
        }

        i++;
        varSwap(list, end, i);
        return i;
    }

    // Method to swap elements using temp variable
    private static <E extends Comparable<E>> void varSwap(List<E> list, int j, int i) {
        E temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

}
