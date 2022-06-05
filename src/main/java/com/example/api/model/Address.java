package com.example.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

import java.util.concurrent.atomic.AtomicInteger;

import static javax.persistence.GenerationType.SEQUENCE;

@Document(collection = "Addresses")
public class Address {
    private static final AtomicInteger counter = new AtomicInteger();
    //Generate new Id
    public static int nextValue() {
        return counter.getAndIncrement();
    }
    @Id
    private long id=nextValue();
    private String street;
    private String city;
    private String country;
    private String zip;
    public Address(){
        super();
    }
    public Address(String street,String city,String country,String zip){
        this.city=city;
        this.street=street;
        this.country=country;
        this.zip=zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
