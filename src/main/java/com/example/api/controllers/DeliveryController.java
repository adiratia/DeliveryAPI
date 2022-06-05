package com.example.api.controllers;

import com.example.api.model.Delivery;
import com.example.api.model.Timeslot;
import com.example.api.reposetories.DeliveryRepository;
import com.example.api.reposetories.TimeslotRepository;
import com.example.api.reposetories.UserRepository;
import com.example.api.services.deliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class DeliveryController {

    @Autowired
    public DeliveryRepository deliveryRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TimeslotRepository timeslotRepository;
    public deliveryService deliveryService;

    //Book a new delivery
    @PostMapping(value= "/deliveries")
    public String createDelivery(@RequestBody Delivery delivery){
        AtomicBoolean flag= new AtomicBoolean(false);
        Iterable<Timeslot> timeslots = timeslotRepository.findAll();
        timeslots.forEach(timeslot -> {
            System.out.println("ID: "+delivery.getTimeslotid());
            if(timeslot.getId()==delivery.getTimeslotid()){
                //
                synchronized(this){
                    Delivery insertedDelivery = deliveryRepository.insert(delivery);

                }
            }
        });
        timeslotRepository.saveAll(timeslots);
        if(flag.get()){
            return "There are already 2 deliveries to this time slot.";
        }
        return "Delivery created";
    }


    //Returns all of weekly's deliveries
    @GetMapping(value= "/deliveries/weekly")
    public List<Delivery> getWeeklyDelivery(){
        return deliveryService.getWeeklyDelivery();
    }
    //Returns all of today's deliveries
    @GetMapping(value= "/deliveries/daily")
    public List<Delivery> getDailyDelivery(){
        return deliveryService.getDailyDelivery();
    }

    //Delete delivery by Id
    @DeleteMapping(value= "/deliveries/{id}")
    public String createDelivery(@PathVariable long id){
        try {
            deliveryRepository.deleteById(id);
            return "Delivery deleted";
        }
        catch (Exception e){
            return "Delivery not found";
        }

    }
    //Mark delivery status as Completed
    @PostMapping(value= "/deliveries/{id}/completed")
    public String deliveryCompleted(@PathVariable long id){
        System.out.println(id);
        try {

            //Find delivery by Id and set status to Completed
            deliveryRepository.findById(id).get().setStatus("Completed");
            return "Delivery status changed to Completed";
        }
        //If the Delivery not found
        catch (Exception e){
            return "Delivery not found";
        }
    }
}
