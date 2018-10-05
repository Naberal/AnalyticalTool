package com.tool.controller;

import com.tool.DAO.AnalyticImp;
import com.tool.DAO.InputDataImp;
import com.tool.view.PrintResult;

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
