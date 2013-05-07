package com.rodcut.model.solutions;

import java.util.ArrayList;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingCommon;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingGreedySolution extends RodCuttingStrategy {

	public ArrayList<Rod> getMaximumRevenueRods(int totalLength, ArrayList<Rod> rodList) {

		// sort rods by price length ratio
		rodList = RodCuttingCommon.getInstance().sortByPriceLengthRatio(rodList);

		// greedy add rods until sum of selected rods length not > total length
		int currentLength = 0;
		int index = 0;
		ArrayList<Rod> selectedRods = new ArrayList<Rod>();
		while (index < rodList.size()) {
			Rod rod = rodList.get(index);
			if (rod.getLength() + currentLength <= totalLength) {
				selectedRods.add(new Rod(rod.getIndex(), rod.getLength(), rod.getPrice()));
				currentLength += rod.getLength();
			}
			else {
				index++;
			}
		}
		return selectedRods;
	}
}