package com.tool.DAO;

import com.tool.model.BasicModel;

import java.io.File;
import java.util.List;

/**
 * Interface for processing input data
 */
public interface InputData {
    /**
     * Method handles incoming data that comes from the outside
     *
     * @param file data from the outside
     * @return list of {@link BasicModel}
     */
    List<BasicModel> getData(File file);
}
