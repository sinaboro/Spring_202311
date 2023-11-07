package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpearker implements Spearker{
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpearker volumeUp");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpearker volumeDown");
	}

}
