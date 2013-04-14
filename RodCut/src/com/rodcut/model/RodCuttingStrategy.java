package com.rodcut.model;

import java.util.List;

public abstract class RodCuttingStrategy {

	public abstract List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList);

	public double getMaximumRevenue(int totalLength, List<Rod> rodList) {
		List<Rod> maximumRevenueRods = getMaximumRevenueRods(totalLength, rodList);
		double sum = 0;
		for (Rod rod : maximumRevenueRods) {
			sum += rod.getPrice();
		}
		return sum;
	}
}
