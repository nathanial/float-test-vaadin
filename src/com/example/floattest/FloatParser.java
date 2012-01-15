package com.example.floattest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FloatParser {
	private FloatDescription description;
	
	public FloatParser(FloatDescription description){
		this.description = description;
	}
	
	public List<Bit> floatToBits(float f){
		int intValue = Float.floatToIntBits(f);
		List<Bit> bits = new ArrayList<Bit>();
		for(int i = 0; i < this.description.getTotalBits(); i++){
			int v = (intValue >> i) & 0x01;
			if(v != 0){
				bits.add(Bit.One);
			} else {
				bits.add(Bit.Zero);
			}
		}
		Collections.reverse(bits);
		return bits;
	}
	
	public FloatParts floatToParts(float f){
		List<Bit> bits = floatToBits(f);
		FloatParts parts = new FloatParts(description, bits);
		return parts;
	}
	
	public float floatFromParts(FloatParts parts){
		boolean isZero = true;
		int sign = parts.getSign() != Bit.Zero ? -1 : 1;
		int e = bitsToInt(parts.getExponent()) - description.getExponentBias();
		if(e != 0){
			isZero = false;
		}
		double exp = Math.pow((double)2.0, (double)e);
		double frac = 0;
		frac += 1;
		for(int i = 0; i < description.getFractionLength(); i++){
			if(parts.getFraction().get(i) == Bit.One){
				frac += Math.pow(2.0, -(i + 1));
				isZero = false;
			}
		}
		if(isZero){
			return 0;
		}
		return (float)(sign * frac * exp);
	}
	
	public int bitsToInt(List<Bit> bits){
		int value = 0;
		for(int i = 0; i < bits.size(); i++){
			Bit b = bits.get(i);
			value <<= 1;
			if(b == Bit.One){
				value |= 0x01;
			} else {
				value &= ~(0x01);
			}
		}
		return value;
	}
}
