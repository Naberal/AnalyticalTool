package main.java.DAO;

import main.java.model.BasicModel;
import main.java.model.Character;
import main.java.model.QueryModel;
import main.java.model.WaitingTimeModel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        model.setDateFrom(LocalDate.parse(date[0], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        if (date.length == 2) {
            model.setDateTo((LocalDate.parse(date[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }
        data.add(model);
    }

    private void AddWaitingTimeModel(String[] dataInLine) throws Exception {
        WaitingTimeModel model = new WaitingTimeModel();
        setDataToModel(model, dataInLine);
        model.setDate(LocalDate.parse(dataInLine[4], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        model.setTime(Integer.parseInt(dataInLine[5]));
        data.add(model);
    }

    private void setDataToModel(BasicModel model, String[] dataInLine) throws Exception {
        if (dataInLine[0].charAt(0) == 'C') {
            model.setCharacter(Character.C);
        } else model.setCharacter(Character.D);
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
