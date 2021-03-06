package com.insightfullogic.java8.answers.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class Question2Test {

    @Test
    public void exampleInB() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String formatted1 = Question2.format.get().format(cal.getTime());
        assertEquals("01-Jan-1970", formatted1);
        String formatted2 = Question2.formatter.get().getFormat().format(cal.getTime());
        assertEquals("01-Jan-1970", formatted2);
    }

}
