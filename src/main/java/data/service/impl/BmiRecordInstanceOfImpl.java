package data.service.impl;

import data.service.BmiRecordInstanceOf;
import data.valueobjects.BmiRecord;

import java.util.Calendar;

public class BmiRecordInstanceOfImpl implements BmiRecordInstanceOf {

    @Override
    public BmiRecord getBmiRecord(float weight, float height) {
        float bmi = getBmi(weight, height);
        BmiRecord record = new BmiRecord(
                Calendar.getInstance(),
                weight,
                height,
                bmi,
                getCategory(bmi)
        );
        return record;
    }

    float getBmi(float weight, float height) {
        return weight / (height * height);
    }

    String getCategory(float bmi) {
        if (bmi < 15) return "Very severely underweight";
        else if (bmi < 16) return "Severely underweight";
        else if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal (healthy weight)";
        else if (bmi < 30) return "Overweight";
        else if (bmi < 35) return "Obese Class I (Moderately obese)";
        else if (bmi < 40) return "Obese Class II (Severely obese)";
        else if (bmi < 45) return "Obese Class III (Very severely obese)";
        else if (bmi < 50) return "Obese Class IV (Morbidly Obese)";
        else if (bmi < 60) return "Obese Class V (Super Obese)";
        else return "Obese Class VI (Hyper Obese) ";
    }
}
