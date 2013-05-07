package com.rodcut.model;

import java.util.ArrayList;

public abstract class RodCuttingStrategy {

	public abstract ArrayList<Rod> getMaximumRevenueRods(int totalLength, ArrayList<Rod> rodList);

}
