package main.java.model;

import java.time.LocalDate;

/**
 * Query model  it expand {@link BasicModel} and expands it with time frames
 */
public class QueryModel extends BasicModel {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public QueryModel() {
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

    /**
     * Checking the time compliance with the time frame
     */
    public boolean validTime(LocalDate date) {
        return this.dateFrom.equals(date) ||
                this.dateFrom.isBefore(date) &&
                        this.getDateTo().isAfter(date);
    }

}
