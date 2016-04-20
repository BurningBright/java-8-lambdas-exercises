package com.insightfullogic.java8.answers.chapter2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.text.DateFormatter;

public class Question2 {

     public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy", Locale.US)));
     
     public final static ThreadLocal<DateFormat> format = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));

}
