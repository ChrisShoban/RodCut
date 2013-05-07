package com.rodcut.model;

import java.util.ArrayList;

public class RodCuttingContext {

	private RodCuttingStrategy strategy;

	public RodCuttingContext(RodCuttingStrategy strategy) {
		this.strategy = strategy;
	}

	public ArrayList<Rod> getMaximumRevenueRodsStrategy(int totalLength, ArrayList<Rod> rods) {
		return this.strategy.getMaximumRevenueRods(totalLength, rods);
	}
}
