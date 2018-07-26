package com.tool.DAO;

import com.tool.model.BasicModel;

import java.io.File;
import java.util.List;

public interface InputData {
    List<BasicModel> getData(File file);
}
