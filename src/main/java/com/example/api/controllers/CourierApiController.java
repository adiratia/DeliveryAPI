package com.example.api.controllers;

import com.example.api.model.CourierApi;
import com.example.api.model.Timeslot;
import com.example.api.reposetories.TimeslotRepository;
import com.example.api.services.DateService;
import com.example.api.services.holidayAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CourierApiController {

    @Autowired
    TimeslotRepository timeslotRepository;
    @Autowired
    holidayAPIService holidayAPIService;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");

    @PostMapping("/courier")
    public String createTimeslots(@RequestBody CourierApi courierApi) {
        List<LocalDate> holidays = holidayAPIService.getHolidays();
        List<Timeslot> weeklyTimeslots = courierApi.getWeeklytimeslots();
        List<Timeslot> timeslotsHolidays = new ArrayList<>();
        for (Timeslot timeslot : weeklyTimeslots){
            String timeslotStartTime = simpleFormat.format(timeslot.getStartTime());
            LocalDate date = LocalDate.parse(timeslotStartTime, formatter);
            Collections.sort(holidays);
            int res = Collections.binarySearch(holidays, date, new DateService());
            if (res<0) {
                timeslotRepository.save(timeslot);
            } else {
                timeslotsHolidays.add(timeslot);
            }
        }
        if (timeslotsHolidays.size()>0) {
            return "Weekly timeslots created";
        } else {
          return "The timeslot are on holidays";
        }
    }
}
