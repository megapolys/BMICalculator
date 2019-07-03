package data.service;

import data.valueobjects.BmiRecord;

public interface BmiRecordInstanceOf {

    BmiRecord getBmiRecord(float weight, float height);

}
