package com.tool.DAO;

import com.tool.model.BasicModel;
import com.tool.model.QueryModel;
import com.tool.model.WaitingTimeModel;

import java.util.ArrayList;
import java.util.List;

public class AnalyticImp implements Analytic {
    private WaitingTimeModel waitingTime;
    private QueryModel query;
    private List<Integer> outData = new ArrayList<>();
    private int count;
    private int analyticTime;

    @Override
    public List<Integer> analysis(List<BasicModel> dataIn) {
        for (int i = 0; i < dataIn.size(); i++) {
            if (dataIn.get(i).getCharacter() == 'D') {
                count = 0;
                analyticTime = 0;
                for (int j = 0; j < i; j++) {
                    if (dataIn.get(j).getCharacter() == 'C' && dataIn.get(j).similar(dataIn.get(i))) {
                        waitingTime = (WaitingTimeModel) dataIn.get(j);
                        query = (QueryModel) dataIn.get(i);
                        boolean before = query.getDateFrom().equals(waitingTime.getDate()) ||
                                query.getDateFrom().isBefore(waitingTime.getDate())
                                        && query.getDateTo().isAfter(waitingTime.getDate());
                        if (before) {
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
