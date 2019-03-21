package main.java.model;

/**
 * Base model of the data line which consists of shared data of the query and the waiting time.
 */
public class BasicModel {
    private Character character;
    private long service;
    private long variation;
    private long question;
    private long category;
    private long subCategory;
    private char response;

    public BasicModel() {
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public long getService() {
        return service;
    }

    public void setService(long service) throws IllegalArgumentException {
        if (service >= 0 && service <= 10) {
            this.service = service;
        } else throw new IllegalArgumentException();
    }

    public long getVariation() {
        return variation;
    }

    public void setVariation(long variation) throws IllegalArgumentException {
        if (variation >= 0 && variation <= 3) {
            this.variation = variation;
        } else throw new IllegalArgumentException();
    }

    public long getQuestion() {
        return question;
    }

    public void setQuestion(long question) throws IllegalArgumentException {
        if (question >= 0 && question <= 10) {
            this.question = question;
        } else throw new IllegalArgumentException();
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) throws IllegalArgumentException {
        if (category >= 0 && category <= 20) {
            this.category = category;
        } else throw new IllegalArgumentException();
    }

    public long getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(long subCategory) throws IllegalArgumentException {
        if (subCategory >= 0 && subCategory <= 5) {
            this.subCategory = subCategory;
        } else throw new IllegalArgumentException();
    }

    public char getResponse() {
        return response;
    }

    public void setResponse(char response) throws IllegalArgumentException {
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
        if (response != o.response) return false;
        if (service != o.service) {
            if (o.service != 0) return false;
        }
        if (question != o.question) {
            if (o.question != 0) return false;
        }
        if (variation != o.variation) {
            if (o.variation != 0) return false;
        }
        if (category != o.category) {
            if (o.category != 0) return false;
        }
        if (subCategory != o.subCategory) {
            if (o.subCategory != 0) return false;
        }
        return true;
    }

}
