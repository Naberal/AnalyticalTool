package main.java;

import main.java.controller.Controller;


import java.io.File;

public class Main {
    /**
     * Main class
     */
    public static void main(String[] args) {
        new Controller().analyticController(new File(args[0]));
    }
}

