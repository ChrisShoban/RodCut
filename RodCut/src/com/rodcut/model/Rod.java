package com.rodcut.model;

import java.util.List;

public class Rod {
	
	private int length;
	
	private List<Integer> cutLengths;
	
	private List<Integer> prices;
	
	private double maximumRevenue;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Integer> getCutLengths() {
		return cutLengths;
	}

	public void setCutLengths(List<Integer> cutLengths) {
		this.cutLengths = cutLengths;
	}

	public List<Integer> getPrices() {
		return prices;
	}

	public void setPrices(List<Integer> prices) {
		this.prices = prices;
	}

	public double getMaximumRevenue() {
		return maximumRevenue;
	}

	public void setMaximumRevenue(double maximumRevenue) {
		this.maximumRevenue = maximumRevenue;
	}
}
