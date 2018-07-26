package com.tool.controller;

import com.tool.DAO.AnalyticImp;
import com.tool.DAO.InputDataImp;

import java.io.File;
import java.util.List;

public class Controller {

    public List controll(File file) {
        List<Integer> list = new AnalyticImp().analysis(new InputDataImp().getData(file));
        return list;
    }
}
