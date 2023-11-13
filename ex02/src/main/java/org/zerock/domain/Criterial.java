package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criterial {

	private int pageNum;  //page 1page, 2page, 3page
	private int amount;  // page당 data갯수

	public Criterial() {
		this(1,10); 
	}

	public Criterial(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
