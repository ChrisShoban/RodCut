package com.rodcut.model;

import java.util.ArrayList;

public abstract class RodCuttingStrategy {

	public abstract ArrayList<Rod> getMaximumRevenueRods(int totalLength, ArrayList<Rod> rodList);

	public double getPricesFromRodsStrategy(int totalLength, ArrayList<Rod> rodList) {
		ArrayList<Rod> maximumRevenueRods = rodList;
		double sum = 0;
		if(maximumRevenueRods == null) {
			return sum;
		}
		for (Rod rod : maximumRevenueRods) {
			sum += rod.getPrice();
		}
		return sum;
	}
}
