package main.java;

import main.java.controller.Controller;


import java.io.File;

public class Main {
    /**
     * Main class
     */
    public static void main(String[] args) {
        new Controller().controller((new File("/home/naberal/IdeaProjects/AnalyticalTool/src/main/Data")));
    }
}

