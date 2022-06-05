package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierApi {
    @JsonProperty("weeklytimeslots")
    List<Timeslot> weeklytimeslots;

    public List<Timeslot> getWeeklytimeslots(){
        return this.weeklytimeslots;
    }
    public void setWeeklytimeslots(List<Timeslot> timeslots){
        this.weeklytimeslots=timeslots;
    }
}
