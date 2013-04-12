package com.rodcut.model;

/**
 * A Rod contains an index, length, price and price ratio (price/length)
 * @author Chris and Sampriya
 *
 */
public class Rod implements Comparable<Rod> {
	
	private int index;
	
	private int length;
	
	private double price;
	
	private Double priceRatio;

	/**
	 * Rods are initialized with an id, length, and price
	 * The price ratio is calculated from the length and price
	 * @param index is the object id
	 * @param length is in integer inches
	 * @param price is allowed to be dollar and cents
	 */
	public Rod(int index, int length, double price) {
		this.index = index;
		this.length = length;
		this.price = price;
		this.priceRatio = this.price/this.length;
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