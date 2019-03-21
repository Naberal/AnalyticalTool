package main.java.DAO;

import main.java.model.BasicModel;
import main.java.model.Character;
import main.java.model.QueryModel;
import main.java.model.WaitingTimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class implements {@link Analytic}
 */
public class AnalyticImp implements Analytic {
    private List<Integer> outData = new ArrayList<>();

    @Override
    public List<Integer> analysis(List<BasicModel> dataIn) {
        for (int i = 0; i < dataIn.size(); i++) {
            if (dataIn.get(i).getCharacter() == Character.D) {
                int count = 0;
                int analyticTime = 0;
                for (int j = 0; j < i; j++) {
                    if (dataIn.get(j).getCharacter() == Character.C && dataIn.get(j).similar(dataIn.get(i))) {
                        WaitingTimeModel waitingTime = (WaitingTimeModel) dataIn.get(j);
                        QueryModel query = (QueryModel) dataIn.get(i);
                        if (query.validTime(waitingTime.getDate())) {
                            count++;
                            analyticTime = (analyticTime + waitingTime.getTime()) / count;
                        }
                    }
                }
                outData.add(analyticTime);
            }
        }
        return outData;
    }
}
