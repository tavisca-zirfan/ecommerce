package com.ngdfw.furniture.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
@Embeddable
public class Dimension {
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal height;
	private BigDecimal seatLength;
	private BigDecimal seatHeight;
	private BigDecimal seatWidth;
	private BigDecimal seatDepth;
	private BigDecimal weight;
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getSeatLength() {
		return seatLength;
	}
	public void setSeatLength(BigDecimal seatLength) {
		this.seatLength = seatLength;
	}
	public BigDecimal getSeatHeight() {
		return seatHeight;
	}
	public void setSeatHeight(BigDecimal seatHeight) {
		this.seatHeight = seatHeight;
	}
	public BigDecimal getSeatWidth() {
		return seatWidth;
	}
	public void setSeatWidth(BigDecimal seatWidth) {
		this.seatWidth = seatWidth;
	}
	public BigDecimal getSeatDepth() {
		return seatDepth;
	}
	public void setSeatDepth(BigDecimal seatDepth) {
		this.seatDepth = seatDepth;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Dimension(BigDecimal length, BigDecimal width, BigDecimal height, BigDecimal seatLength,
			BigDecimal seatWidth, BigDecimal seatDepth, BigDecimal weight) {
		this();
		this.length = length;
		this.width = width;
		this.height = height;
		this.seatLength = seatLength;
		this.seatWidth = seatWidth;
		this.seatDepth = seatDepth;
		this.weight = weight;
	}
	public Dimension(){
		length = new BigDecimal(0);
		width = new BigDecimal(0);
		height = new BigDecimal(0);
		seatLength = new BigDecimal(0);
		seatWidth = new BigDecimal(0);
		seatDepth = new BigDecimal(0);
		weight = new BigDecimal(0);
	}
}
