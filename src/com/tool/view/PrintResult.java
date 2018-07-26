package com.tool.view;

import com.tool.controller.Controller;

import java.io.File;
import java.util.List;

public class PrintResult {
    public void printResult(File file) {
        List<Integer> list = new Controller().controll(file);
        for (Integer i : list
                ) {
            if (i == 0) System.out.println("-");
            else System.out.println(i);

        }
    }
}
