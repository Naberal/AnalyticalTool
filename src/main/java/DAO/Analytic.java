package main.java.DAO;

import main.java.model.BasicModel;

import java.util.List;

/**
 * Data analysis interface
 */
public interface Analytic {
    /**
     * Method of analyzing incoming data in accordance with queries
     * which are in the input data
     *
     * @param dataIn list of {@link BasicModel}
     * @return list processed data (average waiting time for request execution)
     */
    List<Integer> analysis(List<BasicModel> dataIn);
}
