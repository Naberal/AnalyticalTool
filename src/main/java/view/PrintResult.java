package main.java.view;

import java.util.List;

/**
 * Class is responsible for the output of the analysis
 */
public class PrintResult {
    /**
     * Method print analysis to console
     *
     * @param list for print to console
     */
    public void print(List<Integer> list) {
        for (Integer i : list) {
            if (i == 0) System.out.println("-");
            else System.out.println(i);
        }
    }
}
