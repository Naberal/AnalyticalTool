package com.tool.model;

import java.time.LocalDate;
import java.util.Date;

public class WaitingTimeModel extends BasicModel {
    private LocalDate date;
    private int time;

    public WaitingTimeModel() {
    }

    @Override
    public char getCharacter() {
        return super.getCharacter();
    }

    @Override
    public void setCharacter(char character) {
        super.setCharacter(character);
    }

    @Override
    public long getService() {
        return super.getService();
    }

    @Override
    public void setService(long service) {
        super.setService(service);
    }

    @Override
    public long getVariation() {
        return super.getVariation();
    }

    @Override
    public void setVariation(long variation) {
        super.setVariation(variation);
    }

    @Override
    public long getQuestion() {
        return super.getQuestion();
    }

    @Override
    public void setQuestion(long question) {
        super.setQuestion(question);
    }

    @Override
    public long getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(long category) {
        super.setCategory(category);
    }

    @Override
    public long getSubCategory() {
        return super.getSubCategory();
    }

    @Override
    public void setSubCategory(long subCategory) {
        super.setSubCategory(subCategory);
    }

    @Override
    public char getResponse() {
        return super.getResponse();
    }

    @Override
    public void setResponse(char response) {
        super.setResponse(response);
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
