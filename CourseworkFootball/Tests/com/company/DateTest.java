package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testToString() {

        Date testDate=new Date(2020,2,4);
        String resultDate=testDate.toString();
        assertEquals(resultDate, "4-2-2020");
    }

}