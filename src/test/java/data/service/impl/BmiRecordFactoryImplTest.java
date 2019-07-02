package data.service.impl;

import data.valueobjects.BmiRecord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BmiRecordFactoryImplTest {

    private final BmiRecordFactoryImpl bmiRecordFactory = new BmiRecordFactoryImpl();
    private final float delta = 0.01f;

    @Test
    public void getBmiRecordTest() {
        BmiRecord record = bmiRecordFactory.getBmiRecord(20f, 1f);
        assertEquals(20f, record.getBmi(), delta);
        assertEquals(20f, record.getWeight(), delta);
        assertEquals(1f, record.getHeight(), delta);
        assertEquals("Normal (healthy weight)", record.getCategory());
    }

    @Test
    public void getBmiTest() {
        assertEquals(30f, bmiRecordFactory.getBmi(120f, 2f),delta);
    }

    @Test
    public void getCategoryTest() {
        assertEquals("Obese Class III (Very severely obese)", bmiRecordFactory.getCategory(44));
    }
}
