package com.example.CustomQueries2;

import java.util.Random;

public enum Status {
	ONTIME,
	DELAYED,
	CANCELED;
	private static final Random RAND = new Random();
	
	public static Status randomStatus()  {
		Status[] directions = values();
		return directions[RAND.nextInt(directions.length)];
	}
}
