package com.example.CustomQueries2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @PostMapping
    public void initializeRepo(@RequestParam(defaultValue = "100", required = false) int n){
        flightService.initializeRepo(n);
    }
    @GetMapping
    public List<Flight> getFlights(){
        return flightService.flightRepository.findAll();
    }
}
