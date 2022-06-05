package com.example.api.services;

import com.example.api.model.Delivery;
import com.example.api.model.Timeslot;
import com.example.api.reposetories.DeliveryRepository;
import com.example.api.reposetories.TimeslotRepository;
import com.example.api.reposetories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class deliveryService {


    @Autowired
    public DeliveryRepository deliveryRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TimeslotRepository timeslotRepository;
    //Returns all of weekly's deliveries
    public List<Delivery> getWeeklyDelivery(){
        Iterable<Delivery> deliveryIterable=  deliveryRepository.findAll();
        ArrayList<Delivery> weeklyDelivery = new ArrayList<>();
        Date currentDate = new Date();//Current date
        Calendar currentCalendar = Calendar.getInstance();
        Calendar targetCalendar = Calendar.getInstance();
        //Current week
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        //return all timeslots
        Iterable<Timeslot> timeslots = timeslotRepository.findAll();
        try {
            //For each delivery check if the delivery is booked for this week.
            deliveryIterable.forEach(delivery -> {
                timeslots.forEach(timeslot -> {
                    if (timeslot.getId()==delivery.getTimeslotid()){
                        targetCalendar.setTime(timeslot.getStartTime());
                        //week number and year of the delivery
                        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
                        int targetYear = targetCalendar.get(Calendar.YEAR);
                        //Check if the current week and year equal to the delivery week and year.
                        if ( week == targetWeek && year == targetYear) {
                            weeklyDelivery.add(delivery);
                        }
                    }
                });

            });
            return weeklyDelivery;
        }
        catch (Exception e){
            return weeklyDelivery;
        }
    }

    //Returns all of today's deliveries
    public List<Delivery> getDailyDelivery(){
        Iterable<Delivery> deliveryIterable=  deliveryRepository.findAll();
        ArrayList<Delivery> todayDelivery = new ArrayList<>();
        Date currentDate = new Date();//Current date
        Iterable<Timeslot> timeslots = timeslotRepository.findAll();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        try {
            //For each delivery Check if the delivery is booked for today.
            deliveryIterable.forEach(delivery -> {
                timeslots.forEach(timeslot -> {
                    if (timeslot.getId()==delivery.getTimeslotid()){
                        System.out.println(currentDate.toString());
                        System.out.println(timeslot.getStartTime().toString());
                        //Check if the timeslot start time equal to the current date.
                        if ( fmt.format(timeslot.getStartTime()).equals(fmt.format(currentDate))) {
                            //Add to the today's deliveries list.
                            todayDelivery.add(delivery);
                        }
                    }
                });
            });
            return todayDelivery;
        }
        catch (Exception e){
            return todayDelivery;
        }
    }

}
