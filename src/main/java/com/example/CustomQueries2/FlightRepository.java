package com.example.CustomQueries2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	List<Flight> findByStatus(Status status);
	@Query("SELECT f FROM Flight f WHERE f.status = :status1 OR f.status = :status2")
	List<Flight> findByDoubleStatus(Status status1, Status status2);
}
