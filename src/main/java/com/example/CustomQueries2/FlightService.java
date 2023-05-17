package com.example.CustomQueries2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepository;
	public int getRandom(int min, int max){
		return (int) (Math.random() * (max - min)+min);
	}
	public String getRandomString(int n){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i <=n; i++){
			String c = String.valueOf((char)(getRandom(122, 97)));
			str.append(c);
		}
		return str.toString().toUpperCase();
	}
	public void initializeRepo(int n){
		for (int i=0; i<n; i++){
			Flight flight = new Flight();
			flight.setDescription(getRandomString(6));
			flight.setFromAirport(getRandomString(2));
			flight.setToAirport(getRandomString(2));
			flight.setStatus(Status.randomStatus());
			flightRepository.save(flight);
		}
	}
	public Page<Flight> getPage(int page){
		Pageable pageable = PageRequest.of(page, 5, Sort.by("fromAirport").ascending());
		return flightRepository.findAll(pageable);
	}
	public List<Flight> getOnTime(){
		return flightRepository.findByStatus(Status.ONTIME);
	}
	public List<Flight> getDSFlights(Status status1, Status status2){
		return flightRepository.findByDoubleStatus(status1, status2);
	}
	
}
