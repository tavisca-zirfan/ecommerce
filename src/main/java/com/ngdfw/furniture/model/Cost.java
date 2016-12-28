package com.ngdfw.furniture.model;

import javax.persistence.Embeddable;

@Embeddable
public class Cost {
	private int dollar;
	private int cent;
	public int getDollar() {
		return dollar;
	}
	public void setDollar(int dollar) {
		this.dollar = dollar;
	}
	public int getCent() {
		return cent;
	}
	public void setCent(int cent) {
		this.cent = cent;
	}
	
	public Cost(int dollar,int cent) {
		this.dollar = dollar;
		this.cent = cent;
	}
	public Cost(){
		
	}
	
	@Override
	public String toString() {
		return String.format("%d.%02d",dollar,cent);
	}
}
