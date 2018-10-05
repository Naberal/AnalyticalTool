package com.tool.DAO;

import com.tool.model.BasicModel;
import com.tool.model.QueryModel;
import com.tool.model.WaitingTimeModel;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implements {@link InputData}
 */
public class InputDataImp implements InputData {
    private List<BasicModel> data = new ArrayList<>();

    @Override
    public List<BasicModel> getData(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String buffer;
            int lines = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < lines; i++) {
                buffer = bufferedReader.readLine();
                try {
                    String[] dataInLine = buffer.split(" ");
                    if (dataInLine[0].equals("C")) {
                        AddWaitingTimeModel(dataInLine);
                    }
                    if (dataInLine[0].equals("D")) {
                        AddQueryModel(dataInLine);
                    }
                } catch (NullPointerException e) {
                    return data;
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void AddQueryModel(String[] dataInLine) throws Exception {
        QueryModel model = new QueryModel();
        setDataToModel(model, dataInLine);
        String[] date = dataInLine[4].split("-");
        String[] dateFrom = date[0].split("\\.");
        model.setDateFrom(LocalDate.of(Integer.parseInt(dateFrom[2]), Integer.parseInt(dateFrom[1]),
                Integer.parseInt(dateFrom[0])));
        if (date.length == 2) {
            String[] dateTo = date[1].split("\\.");
            model.setDateTo(LocalDate.of(Integer.parseInt(dateTo[2]), Integer.parseInt(dateTo[1]),
                    Integer.parseInt(dateTo[0])));
        }
        data.add(model);
    }

    private void AddWaitingTimeModel(String[] dataInLine) throws Exception {
        WaitingTimeModel model = new WaitingTimeModel();
        setDataToModel(model, dataInLine);
        String[] date = dataInLine[4].split("\\.");
        model.setDate(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]),
                Integer.parseInt(date[0])));
        model.setTime(Integer.parseInt(dataInLine[5]));
        data.add(model);
    }

    private void setDataToModel(BasicModel model, String[] dataInLine) throws Exception {
        model.setCharacter(dataInLine[0].charAt(0));
        String[] dataInLine1 = dataInLine[1].split("\\.");
        String[] dataInLine2 = dataInLine[2].split("\\.");
        model.setResponse(dataInLine[3].charAt(0));
        if (dataInLine1[0].equals("*")) return;
        else model.setService(Long.parseLong(dataInLine1[0]));
        if (dataInLine1.length == 2) model.setVariation(Long.parseLong(dataInLine1[1]));
        if (dataInLine2[0].equals("*")) return;
        else model.setQuestion(Long.parseLong(dataInLine2[0]));
        if (dataInLine2.length == 2) model.setCategory(Long.parseLong(dataInLine2[1]));
        if (dataInLine2.length == 3) model.setSubCategory(Long.parseLong(dataInLine2[2]));
    }
}
