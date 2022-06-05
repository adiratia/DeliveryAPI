package com.example.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.atomic.AtomicInteger;

@Document(collection = "Delivery")
public class Delivery {
    private static final AtomicInteger counter = new AtomicInteger();
    public static int nextValue() {
        return counter.getAndIncrement();
    }
    @Id
    private long id=nextValue();
    private String status="Created";
    private long timeslotid;
    private User user;
    public Delivery(){
        super();
    }
    public Delivery(long timeslotid,User user){
        this.timeslotid=timeslotid;
        this.user=user;

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimeslotid() {
        return this.timeslotid;
    }

    public void setTimeslotid(long timeslotid) {
        this.timeslotid = timeslotid;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
