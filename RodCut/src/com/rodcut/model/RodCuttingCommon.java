package com.rodcut.model;

import java.util.Collections;
import java.util.List;

public class RodCuttingCommon {

	private static RodCuttingCommon instance = new RodCuttingCommon();

	private RodCuttingCommon() { }

	public static RodCuttingCommon getInstance() {
		return instance;
	}
	
	public List<Rod> sortByPriceLengthRatio(List<Rod> rodList) {
		Collections.sort(rodList);
		Collections.reverse(rodList); // Descending Order
		return rodList;
	}
	
}