package com.tool.model;

import java.time.LocalDate;
import java.util.Date;

public class QueryModel extends BasicModel {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public QueryModel() {
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

}
