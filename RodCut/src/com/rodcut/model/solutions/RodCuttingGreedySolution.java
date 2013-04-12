package com.rodcut.model.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingCommon;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingGreedySolution extends RodCuttingStrategy {

	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {

		// sort rods by price length ratio
		rodList = RodCuttingCommon.getInstance().sortByPriceLengthRatio(rodList);

		// greedy add rods until sum of selected rods length not > total length
		int currentLength = 0;
		int index = 0;
		List<Rod> selectedRods = new ArrayList<Rod>();
		while (currentLength <= totalLength) {
			Rod rod = rodList.get(index);
			if (rod.getLength() <= currentLength) {
				selectedRods.add(new Rod(rod.getIndex(), rod.getLength(), rod.getPrice()));
				currentLength += rod.getLength();
			}
			else {
				index++;
			}
		}
		return selectedRods;
	}

	public double getMaximumRevenue(int totalLength, List<Rod> rodList) {
		List<Rod> maximumRevenueRods = getMaximumRevenueRods(totalLength, rodList);
		double sum = 0;
		for (Rod rod : maximumRevenueRods) {
			sum += rod.getPrice();
		}
		return sum;
	}
}