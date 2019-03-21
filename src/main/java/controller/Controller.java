package main.java.controller;

import main.java.DAO.AnalyticImp;
import main.java.DAO.InputDataImp;
import main.java.view.PrintResult;

import java.io.File;
import java.util.List;

/**
 * Class analyticController
 */
public class Controller {
    public void analyticController(File file) {
        List<Integer> list = new AnalyticImp().analysis(new InputDataImp(file).getData());
        new PrintResult().print(list);
    }
}
