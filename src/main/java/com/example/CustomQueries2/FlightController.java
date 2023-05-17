package com.example.CustomQueries2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @GetMapping("/page")
    public Page<Flight> getPageOfFlight(@RequestParam int page){
        return flightService.getPage(page);
    }
    @GetMapping("/on-time")
    public List<Flight> getOnTimeFlights(){
        return flightService.getOnTime();
    }
    @GetMapping("/statuses")
    public List<Flight> getDSFlights(@RequestParam Status status1, @RequestParam Status status2){
        return flightService.getDSFlights(status1, status2);
    }
}
