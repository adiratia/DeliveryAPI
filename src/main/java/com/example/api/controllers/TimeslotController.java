package com.example.api.controllers;

import com.example.api.model.Address;
import com.example.api.model.Timeslot;
import com.example.api.model.User;
import com.example.api.reposetories.AddressRepository;
import com.example.api.reposetories.TimeslotRepository;
import com.example.api.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class TimeslotController {
    @Autowired
    public TimeslotRepository timeslotRepository;
    @Autowired
    public TimeslotService timeslotService;
    @GetMapping(value = "/gettimeslots")
    public List<Timeslot> getTimeslot(){
        return timeslotRepository.findAll();

    }
    //Get all timeslots that support particular address.
    @PostMapping(value= "/timeslots")
    public List<Timeslot> timeslotsByAddress( @RequestBody Map<String, Address> address){
         return timeslotService.timeslotsByAddress(address);
    }
    //Create new timeslot
    @PostMapping(value= "/createtimeslot")
    public String createTimeslot(@RequestBody Timeslot timeslot){
        Timeslot insertedTimeslot = timeslotRepository.insert(timeslot);
        return "Timeslot created";
    }
}
