package com.rodcut.test;

import java.util.ArrayList;

import com.rodcut.model.RodCuttingModel;

public class RodCuttingTest {
	
	public static void main(String[] args) {
		int totalLength = 24;
		ArrayList<Double> prices = new ArrayList<Double>();
		RodCuttingModel model = new RodCuttingModel(totalLength, prices);
		System.out.println("Greedy Algorithm Maximum Revenue : " + model.getGreedyAlgorithmMaximumRevenue());
		System.out.println("Dynamic Programming Algorithm Maximum Revenue : " + model.getDynamicAlgorithmMaximumRevenue());
		System.out.println("Branch And Bound Algorithm Maximum Revenue : " + model.getBranchAndBoundAlgorithmMaximumRevenue());
		System.out.println("Divide And Conquer Algorithm Maximum Revenue : " + model.getDivideAndConquerAlgorithmMaximumRevenue());
	}
}
