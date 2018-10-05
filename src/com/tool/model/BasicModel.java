package com.tool.model;

/**
 * Base model of the data line which consists of shared data of the query and the waiting time.
 */
public class BasicModel {
    private char character;
    private long service;
    private long variation;
    private long question;
    private long category;
    private long subCategory;
    private char response;

    public BasicModel() {
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        if (character == 'C' || character == 'D') {
            this.character = character;
        } else throw new IllegalArgumentException();
    }

    public long getService() {
        return service;
    }

    public void setService(long service) {
        if (service >= 0 && service <= 10) {
            this.service = service;
        } else throw new IllegalArgumentException();
    }

    public long getVariation() {
        return variation;
    }

    public void setVariation(long variation) {
        if (variation >= 0 && variation <= 3) {
            this.variation = variation;
        } else throw new IllegalArgumentException();
    }

    public long getQuestion() {
        return question;
    }

    public void setQuestion(long question) {
        if (question >= 0 && question <= 10) {
            this.question = question;
        } else throw new IllegalArgumentException();
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        if (category >= 0 && category <= 20) {
            this.category = category;
        } else throw new IllegalArgumentException();
    }

    public long getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(long subCategory) {
        if (subCategory >= 0 && subCategory <= 5) {
            this.subCategory = subCategory;
        } else throw new IllegalArgumentException();
    }

    public char getResponse() {
        return response;
    }

    public void setResponse(char response) {
        if (service >= 0 && service <= 10) {
            this.response = response;
        } else throw new IllegalArgumentException();
    }

    /**
     * Method for checking query data and waiting time for similarity
     *
     * @param o must extend {@link BasicModel}
     * @return true if objects similar
     */
    public boolean similar(BasicModel o) {

        BasicModel that = o;

        if (response != that.response) return false;
        if (service != that.service) {
            if (that.service != 0) return false;
        }
        if (question != that.question) {
            if (that.question != 0) return false;
        }
        if (variation != that.variation) {
            if (that.variation != 0) return false;
        }
        if (category != that.category) {
            if (that.category != 0) return false;
        }
        if (subCategory != that.subCategory) {
            if (that.subCategory != 0) return false;
        }
        return true;
    }

}
