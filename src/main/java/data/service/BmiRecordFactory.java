package data.service;

import data.valueobjects.BmiRecord;

public interface BmiRecordFactory {

    BmiRecord getBmiRecord(float weight, float height);

}
