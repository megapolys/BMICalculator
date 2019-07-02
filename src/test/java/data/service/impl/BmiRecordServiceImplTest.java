package data.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class BmiRecordServiceImplTest {

    private final BmiRecordServiceImpl bmiRecordService = new BmiRecordServiceImpl();

    @Test
    public void getBmiRecordsTest() {
        bmiRecordService.setBmiRecordFactory(new BmiRecordFactoryImpl());
        bmiRecordService.add("40.0", "2.0");
        bmiRecordService.add("90", "3");
        bmiRecordService.add("50.111", "1.5");
        assertEquals(3, bmiRecordService.getBmiRecords().size());
    }

    @Test
    public void isValidFloatTest() {
        assertTrue(bmiRecordService.isValidFloat("1"));
        assertTrue(bmiRecordService.isValidFloat("1.1"));
        assertTrue(bmiRecordService.isValidFloat("123.1234567890"));
        assertFalse(bmiRecordService.isValidFloat("123.1.234567890"));
        assertFalse(bmiRecordService.isValidFloat("asd1"));
        assertFalse(bmiRecordService.isValidFloat(".123"));
        assertFalse(bmiRecordService.isValidFloat(""));
    }
}
