package com.example.api.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class DateService  implements Comparator<LocalDate> {
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public int compare(LocalDate date1, LocalDate date2) {
        return formatter.format(date1).compareTo(formatter.format(date2));
    }
}
