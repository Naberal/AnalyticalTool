package main.java.DAO;

import main.java.model.BasicModel;

import java.util.List;

/**
 * Interface for processing input data
 */
public interface InputData {
    /**
     * Method handles incoming data that comes from the outside
     *
     * @return list of {@link BasicModel}
     */
    List<BasicModel> getData();
}
