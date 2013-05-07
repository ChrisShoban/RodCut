package com.rodcut.model.solutions;

import java.util.ArrayList;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingCommon;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingGreedySolution extends RodCuttingStrategy {
	
	private ArrayList<Rod> rods;

	public ArrayList<Rod> getMaximumRevenueRods(int totalLength, ArrayList<Rod> rodList) {

		rods = new ArrayList<Rod>(rodList);
		// sort rods by price length ratio
		rods = RodCuttingCommon.getInstance().sortByPriceLengthRatio(rods);

		// greedy add rods until sum of selected rods length not > total length
		int currentLength = 0;
		int index = 0;
		ArrayList<Rod> selectedRods = new ArrayList<Rod>();
		while (index < rods.size()) {
			Rod rod = rods.get(index);
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