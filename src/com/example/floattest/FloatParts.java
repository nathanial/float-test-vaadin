package com.example.floattest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloatParts {
	private final Bit sign;
	private final List<Bit> exponent = new ArrayList<Bit>();
	private final List<Bit> fraction = new ArrayList<Bit>();
	
	public FloatParts(FloatDescription description, List<Bit> bits){
		Queue<Bit> queue = new LinkedList<Bit>(bits);
		sign = queue.poll();
		for(int i = 0; i < description.getExponentLength(); i++){
			exponent.add(queue.poll());
		}
		for(int i = 0; i < description.getFractionLength(); i++){
			fraction.add(queue.poll());
		}	
	}
	
	public Bit getSign() {
		return sign;
	}
	public List<Bit> getExponent() {
		return exponent;
	}
	public List<Bit> getFraction() {
		return fraction;
	}
}
