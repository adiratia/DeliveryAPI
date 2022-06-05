package com.example.api.reposetories;
import com.example.api.model.Address;
import com.example.api.model.Timeslot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeslotRepository extends MongoRepository<Timeslot,Long> {

}
