package data.valueobjects;

import java.util.Calendar;

public class BmiRecord {
    final private Calendar calendar;
    final private float weight;
    final private float height;
    final private float bmi;
    final private String category;

    public BmiRecord(Calendar calendar, float weight, float height, float bmi, String category) {
        this.calendar = calendar;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.category = category;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public float getBmi() {
        return bmi;
    }

    public String getCategory() {
        return category;
    }

}
