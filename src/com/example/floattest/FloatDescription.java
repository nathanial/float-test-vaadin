package com.example.floattest;

public class FloatDescription {
	
	private final int exponentLength;
	private final int fractionLength;
	private final int exponentBias;
	
	public FloatDescription(int exponentLength, 
							int fractionLength,
							int exponentBias){
		this.exponentLength = exponentLength;
		this.fractionLength = fractionLength;
		this.exponentBias = exponentBias;
	}
	
	public int getExponentLength() {
		return 0;
	}

	public int getFractionLength() {
		return 0;
	}

	public int getTotalBits() {
		return 0;
	}
	
	public int getExponentBias(){
		return exponentBias;
	}
	
}
