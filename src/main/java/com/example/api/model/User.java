package com.example.api.model;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.concurrent.atomic.AtomicInteger;

@Document(collection = "USERS")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid" )
    private String id;
    private String name;
    private Address address;
    public User(){
        super();
    }

    public User(String name, Address address){
        super();
        this.name=name;
        this.address=address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId (){
        return  this.id;
    }
    public String getName(){
        return this.name;
    }


}
