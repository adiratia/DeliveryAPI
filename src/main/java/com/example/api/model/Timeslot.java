package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Document(collection = "Timeslots")
public class Timeslot {
    private static final AtomicInteger counter = new AtomicInteger();
    public static int nextValue() {
        return counter.getAndIncrement();
    }
    @Id
    private long Id=nextValue() ;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private ArrayList<Address> addresses= new ArrayList<>();
    private int deliveryCount;

    public Timeslot(){
        super();
    }
    public Timeslot(Date start,Date end, ArrayList<Address> addresses){
        this.startTime=start;
        this.endTime=end;
        this.addresses=addresses;
        this.deliveryCount=0;
    }
   /* public Timeslot(Date start,Date end, ArrayList<Address> addresses,long id){
        this.startTime=start;
        this.endTime=end;
        this.addresses=addresses;
        this.Id=id;
    }*/

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime ) {
        this.startTime = startTime;
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }
    public int getDeliveryCount() {
        return this.deliveryCount;
    }
    public void setDeliveryCount(int deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

}
