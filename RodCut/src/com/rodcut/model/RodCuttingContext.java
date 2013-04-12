package com.rodcut.model;

import java.util.ArrayList;
import java.util.List;

public class RodCuttingContext {

	private RodCuttingStrategy strategy;
	private List<Rod> rodList;
	private ArrayList<Double> priceList;

	public RodCuttingContext(RodCuttingStrategy strategy) {
		this.strategy = strategy;
		rodList = new ArrayList<>();
		priceList = new ArrayList<>();
	}

	public double getMaximumRevenueStrategy(int totalLength, ArrayList<Double> prices) {
		createRods(totalLength, prices);
		return this.strategy.getMaximumRevenue(totalLength, rodList);
	}

	public List<Rod> getMaximumRevenueRodsStrategy(int totalLength, ArrayList<Double> prices) {
		createRods(totalLength, prices);
		return this.strategy.getMaximumRevenueRods(totalLength, rodList);
	}

	private void createRods(int totalLength, ArrayList<Double> prices) {
		// Prices.length <= total length
		setRodListLength(totalLength, prices);

		// Create Rods of size total length
		int index = 0;
		for (double price : priceList) {
			Rod rod = new Rod(index++, index, price);
			rodList.add(rod);
		}
	}

	private void setRodListLength(int totalLength, ArrayList<Double> prices) {
		if (prices == null) {
			return;
		}
		if (totalLength < prices.size()) {
			priceList = new ArrayList<Double>(prices.subList(0, totalLength));
		}
		else {
			priceList = prices;
		}
	}

}
