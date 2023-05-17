package com.example.CustomQueries2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepository;
	public int getRandom(int min, int max){
		return (int) (Math.random() * (max - min)+min);
	}
	public String getRandomString(int n){
		StringBuilder str = new StringBuilder();
		//a=64 z=100
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
			flight.setFlightStatus(Status.randomStatus());
			flightRepository.save(flight);
		}
	}
	
}
