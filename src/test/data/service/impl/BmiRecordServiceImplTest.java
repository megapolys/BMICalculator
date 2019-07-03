package data.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class BmiRecordServiceImplTest {

    private final BmiRecordServiceImpl bmiRecordService = new BmiRecordServiceImpl();

    @Test
    public void getBmiRecordsTest() {
        bmiRecordService.setBmiRecordInstanceOf(new BmiRecordInstanceOfImpl());
        bmiRecordService.add("40.0", "2.0");
        bmiRecordService.add("90", "3");
        bmiRecordService.add("50.111", "1.555555555555555555555555555555555");
        assertEquals(3, bmiRecordService.getBmiRecords().size());
    }

    @Test
    public void isValidNotMinusFloatTest() {
        assertTrue(bmiRecordService.isValidNotMinusFloat("1"));
        assertTrue(bmiRecordService.isValidNotMinusFloat("1.1"));
        assertTrue(bmiRecordService.isValidNotMinusFloat("123.1234567890"));
        assertFalse(bmiRecordService.isValidNotMinusFloat("123.1.234567890"));
        assertFalse(bmiRecordService.isValidNotMinusFloat("asd1"));
        assertFalse(bmiRecordService.isValidNotMinusFloat(".123"));
        assertFalse(bmiRecordService.isValidNotMinusFloat(""));
    }
}
