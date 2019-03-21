package main.java.model;

import java.time.LocalDate;

/**
 * Waiting time model  it expand {@link BasicModel} and extends its query time and execution time
 */
public class WaitingTimeModel extends BasicModel {
    private LocalDate date;
    private int time;

    public WaitingTimeModel() {
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
