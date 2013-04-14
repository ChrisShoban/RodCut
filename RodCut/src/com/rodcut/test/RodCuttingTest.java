package com.rodcut.test;

import java.util.ArrayList;

import com.rodcut.model.RodCuttingModel;

public class RodCuttingTest {
	
	public static void main(String[] args) {
		int totalLength = 4;
		ArrayList<Double> prices = new ArrayList<Double>();
		prices.add(1.0);
		prices.add(6.0);
		prices.add(3.0);
		prices.add(4.0);
		RodCuttingModel model = new RodCuttingModel(totalLength, prices);
		System.out.println("Greedy Algorithm Maximum Revenue : " + model.getGreedyAlgorithmMaximumRevenue());
		// System.out.println("Dynamic Programming Algorithm Maximum Revenue : " + model.getDynamicAlgorithmMaximumRevenue());
		 System.out.println("Branch And Bound Algorithm Maximum Revenue : " + model.getBranchAndBoundAlgorithmMaximumRevenue());
		// System.out.println("Divide And Conquer Algorithm Maximum Revenue : " + model.getDivideAndConquerAlgorithmMaximumRevenue());
	}
}
