package data.service;

import data.valueobjects.BmiRecord;

import java.util.List;

public interface BmiRecordService {
    List<BmiRecord> getBmiRecords();
    BmiRecord add(String weight, String height);
}
