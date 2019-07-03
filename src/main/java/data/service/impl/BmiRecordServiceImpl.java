package data.service.impl;

import data.service.BmiRecordInstanceOf;
import data.service.BmiRecordService;
import data.valueobjects.BmiRecord;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BmiRecordServiceImpl implements BmiRecordService {

    private List<BmiRecord> records;
    private BmiRecordInstanceOf bmiRecordInstanceOf;

    @Inject
    public void setBmiRecordInstanceOf(BmiRecordInstanceOf bmiRecordInstanceOf) {
        this.bmiRecordInstanceOf = bmiRecordInstanceOf;
    }

    public BmiRecordServiceImpl() {
        records = new ArrayList<>();
    }

    @Override
    public BmiRecord add(String weight, String height) {
        if (isValidNotMinusFloat(weight) && isValidNotMinusFloat(height)) {
            BmiRecord record =
                    bmiRecordInstanceOf.getBmiRecord(Float.parseFloat(weight), Float.parseFloat(height));
            records.add(record);
            return record;
        }
        return null;
    }

    boolean isValidNotMinusFloat(String floatStr) {
        if (floatStr == null) {
            return false;
        }
        return floatStr.matches("[0-9]+(\\.[0-9]+)?");
    }

    @Override
    public List<BmiRecord> getBmiRecords() {
        records.sort((r1, r2) -> r2.getCalendar().compareTo(r1.getCalendar()));
        return records;
    }

}
