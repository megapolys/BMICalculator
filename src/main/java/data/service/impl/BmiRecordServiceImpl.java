package data.service.impl;

import data.service.BmiRecordFactory;
import data.service.BmiRecordService;
import data.valueobjects.BmiRecord;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BmiRecordServiceImpl implements BmiRecordService {

    private List<BmiRecord> records;
    private BmiRecordFactory bmiRecordFactory;

    @Inject
    public void setBmiRecordFactory(BmiRecordFactory bmiRecordFactory) {
        this.bmiRecordFactory = bmiRecordFactory;
    }

    public BmiRecordServiceImpl() {
        System.out.println("Constructor BmiRecordServiceImpl processing...");
        records = new ArrayList<>();
    }

    @Override
    public BmiRecord add(String weight, String height) {
        if (isValidFloat(weight) && isValidFloat(height)) {
            BmiRecord record =
                    bmiRecordFactory.getBmiRecord(Float.parseFloat(weight), Float.parseFloat(height));
            records.add(record);
            return record;
        }
        return null;
    }

    boolean isValidFloat(String floatStr) {
        return floatStr.matches("[0-9]+(\\.[0-9]+)?");
    }

    @Override
    public List<BmiRecord> getBmiRecords() {
        return records;
    }

}
