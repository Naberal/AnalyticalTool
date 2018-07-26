package com.tool.DAO;

import com.tool.model.BasicModel;

import java.util.List;

public interface Analytic {
    List<Integer> analysis(List<BasicModel> dataIn);
}
