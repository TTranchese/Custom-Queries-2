package com.example.CustomQueries2;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @Column
    private String fromAirport;
    @Column
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private Status flightStatus;
    
    public Status getFlightStatus() {
        return flightStatus;
    }
    
    public void setFlightStatus(Status flightStatus) {
        this.flightStatus = flightStatus;
    }
    
    public Flight() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getFromAirport() {
        return fromAirport;
    }
    
    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }
    
    public String getToAirport() {
        return toAirport;
    }
    
    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
}
