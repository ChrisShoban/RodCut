package com.rodcut.model;

import java.util.ArrayList;

public class RodCuttingContext {
	private RodCuttingStrategy strategy;
	 
    public RodCuttingContext(RodCuttingStrategy strategy) {
        this.strategy = strategy;
    }
 
    public Rod executeStrategy(int totalLength, ArrayList<Integer> prices) {
        return this.strategy.getMaximumRevenue(totalLength, prices);
    }
}
