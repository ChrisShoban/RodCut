package com.rodcut.model;

public class Rod implements Comparable<Rod> {
	
	private int index;
	
	private int length;
	
	private double price;
	
	private Double priceRatio;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Double getPriceRatio() {
		return priceRatio;
	}

	public void setPriceRatio(Double priceRatio) {
		this.priceRatio = priceRatio;
	}
	
	public int compareTo(Rod object) {
		return this.priceRatio.compareTo(object.priceRatio); 
	}
}