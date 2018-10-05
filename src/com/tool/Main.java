package com.tool;

import com.tool.controller.Controller;


import java.io.File;

public class Main {
    /**
     * Write your file location!!!
     */
    public static void main(String[] args) {
        new Controller().controller((new File("file location")));
    }
}

