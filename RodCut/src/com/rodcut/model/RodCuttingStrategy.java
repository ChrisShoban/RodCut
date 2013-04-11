package com.rodcut.model;

import java.util.ArrayList;

public interface RodCuttingStrategy {
	Rod getMaximumRevenue(int totalLength, ArrayList<Integer> prices);
}
