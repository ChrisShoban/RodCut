package com.rodcut.model;

public class Rod implements Comparable<Rod> {
	
	private int index;
	
	private int length;
	
	private double price;
	
	private Double priceRatio;

	public Rod(int index, int length, double price, Double priceRatio ) {
		this.index = index;
		this.length = length;
		this.price = price;
		this.priceRatio = priceRatio;
	}
	
	public int getIndex() {
		return index;
	}

	public int getLength() {
		return length;
	}

	public double getPrice() {
		return price;
	}

	public Double getPriceRatio() {
		return priceRatio;
	}

	public int compareTo(Rod object) {
		return this.priceRatio.compareTo(object.priceRatio); 
	}
}