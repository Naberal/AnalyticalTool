package main.java.controller;

import main.java.DAO.AnalyticImp;
import main.java.DAO.InputDataImp;
import main.java.view.PrintResult;

import java.io.File;
import java.util.List;

/**
 * Class controller
 */
public class Controller {
    private PrintResult result= new PrintResult();

    public void controller(File file) {
        List<Integer> list = new AnalyticImp().analysis(new InputDataImp().getData(file));
        result.print(list);
    }
}
