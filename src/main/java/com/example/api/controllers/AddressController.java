package com.example.api.controllers;

import com.example.api.model.Address;
import com.example.api.reposetories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {
    @Autowired
    public AddressRepository addressRepository;

    @PostMapping(value= "/resolve-address")
    public String resolveAddress(@RequestBody Map<String, String> searchTerm){
        try {
            System.out.println(searchTerm.get("searchTerm"));
            //Split the one line address to seperated address (steet,city,country,zip)
            List<String> splitAddress = Arrays.asList(searchTerm.get("searchTerm").split(","));
            String street = splitAddress.get(0);
            String city = splitAddress.get(1);
            String country = splitAddress.get(2);
            String zip = splitAddress.get(3);
            //Create new address
            Address address = new Address(street, city, country, zip);
            //Add the address to DB
            Address insertedAddress = addressRepository.insert(address);
            return "Address resolved";

        }
        catch (Exception e){
            return "Address not resolved,try again with correct format (street,city,country,zip)";
        }

    }
}
