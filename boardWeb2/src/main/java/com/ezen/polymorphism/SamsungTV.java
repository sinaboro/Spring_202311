package com.ezen.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {

	@Autowired
	@Qualifier("apple")
	private Spearker spearker;
	
	private int price;
	
	
	public void setSpearker(Spearker spearker) {
		this.spearker = spearker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("생성자 SamsungTV");
		System.out.println("spearker : ");
		
	}

	public SamsungTV(Spearker spearker) {
		this.spearker = spearker;
		System.out.println("생성자 SamsungTV(spearker)");
	}

	public SamsungTV(Spearker spearker, int price) {
		this.spearker = spearker;
		this.price =  price;
		System.out.println("생성자 SamsungTV(spearker) : " + price);
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV  powerOn : " + price);
		
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV  powerOff");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV  volumeUp");
//		spearker  = new SonySpearker();
		spearker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV  volumeDown");
//		spearker  = new SonySpearker();
		spearker.volumeDown();
	}

}
