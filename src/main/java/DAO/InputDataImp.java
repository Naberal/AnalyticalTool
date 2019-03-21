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
    private File file;

    public InputDataImp(File file) {
        this.file = file;
    }

    @Override
    public List<BasicModel> getData() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String buffer;
            int lines = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < lines; i++) {
                buffer = bufferedReader.readLine();
                try {
                    String[] dataInLine = buffer.split(" ");
                    if (dataInLine[0].equals("C")) {
                        data.add(parseWaitingTimeModel(dataInLine));
                    }
                    if (dataInLine[0].equals("D")) {
                        data.add(parseQueryModel(dataInLine));
                    }
                } catch (NullPointerException e) {
                    return data;
                } catch (IllegalArgumentException e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private QueryModel parseQueryModel(String[] data) {
        QueryModel model = new QueryModel();
        parseBasicModel(model, data);
        String[] date = data[4].split("-");
        model.setDateFrom(LocalDate.parse(date[0], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        if (date.length == 2) {
            model.setDateTo((LocalDate.parse(date[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }
        return model;
    }

    private WaitingTimeModel parseWaitingTimeModel(String[] data) {
        WaitingTimeModel model = new WaitingTimeModel();
        parseBasicModel(model, data);
        model.setDate(LocalDate.parse(data[4], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        model.setTime(Integer.parseInt(data[5]));
        return model;
    }

    private void parseBasicModel(BasicModel model, String[] data) {
        if (data[0].charAt(0) == 'C') {
            model.setCharacter(Character.C);
        }
        if (data[0].charAt(0) == 'D') {
            model.setCharacter(Character.D);
        }
        String[] serviceAndVariation = data[1].split("\\.");
        String[] questionCategories = data[2].split("\\.");
        model.setResponse(data[3].charAt(0));
        if (serviceAndVariation[0].equals("*")) return;
        else model.setService(Long.parseLong(serviceAndVariation[0]));
        if (serviceAndVariation.length == 2) model.setVariation(Long.parseLong(serviceAndVariation[1]));
        if (questionCategories[0].equals("*")) return;
        else model.setQuestion(Long.parseLong(questionCategories[0]));
        if (questionCategories.length == 2) model.setCategory(Long.parseLong(questionCategories[1]));
        if (questionCategories.length == 3) model.setSubCategory(Long.parseLong(questionCategories[2]));
    }
}
