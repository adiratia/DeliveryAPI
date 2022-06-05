package com.example.api.services;

import com.example.api.model.Address;
import com.example.api.model.Timeslot;
import com.example.api.reposetories.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TimeslotService {
    @Autowired
    TimeslotRepository timeslotRepository;
    public List<Timeslot> timeslotsByAddress(Map<String, Address> address){
        //get the all timeslots
        Iterable<Timeslot> timeslots = timeslotRepository.findAll();
        ArrayList<Timeslot> filter = new ArrayList<>() ;
        System.out.println(address.get("address").getCountry());
        try {
            //For each timeslot check if the particular address supported by the timeslot.
            timeslots.forEach(timeslot -> {
                timeslot.getAddresses().forEach(address1 -> {
                            System.out.println(address1.getCountry()+ "" +address.get("address").getCountry());
                            System.out.println(address1.getZip()+ "" +address.get("address").getZip());
                            //if the particular address supported by the timeslot
                            if (address1.getCity().equals(address.get("address").getCity())
                                    && address1.getCountry().equals(address.get("address").getCountry())
                                    && address1.getStreet().equals(address.get("address").getStreet())
                                    && address1.getZip().equals(address.get("address").getZip())) {
                                System.out.println("Yes");
                                //Add the timeslot to new list
                                filter.add(timeslot);
                            }
                        }
                );
            });
            //Return the result
            return filter;
        }
        catch (Exception e){
            return filter;
        }
    }
}
