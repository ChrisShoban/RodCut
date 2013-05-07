package com.rodcut.model;

import java.util.ArrayList;

import com.rodcut.model.solutions.RodCuttingDynamicSolution;

public class RodCuttingModel {
	
	private RodCuttingContext context;
	
	private double greedyAlgorithmMaximumRevenue;
	
	private double dynamicAlgorithmMaximumRevenue;
	
	private double branchAndBoundAlgorithmMaximumRevenue;
	
	private double divideAndConquerAlgorithmMaximumRevenue;
	
	private ArrayList<Rod> greedyAlgorithmMaximumRevenueRodList;
	
	private ArrayList<Rod> dynamicAlgorithmMaximumRevenueRodList;
	
	private ArrayList<Rod> branchAndBoundAlgorithmMaximumRevenueRodList;
	
	private ArrayList<Rod> divideAndConquerAlgorithmMaximumRevenueRodList;
	
	
	public RodCuttingModel(int totalLength, ArrayList<Double> prices) {
		
//		context = new RodCuttingContext(new RodCuttingGreedySolution());
//		greedyAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
//		greedyAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);

		context = new RodCuttingContext(new RodCuttingDynamicSolution());
		dynamicAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);
		dynamicAlgorithmMaximumRevenue = context.getPricesFromRodsStrategy(totalLength, dynamicAlgorithmMaximumRevenueRodList);


//		context = new RodCuttingContext(new RodCuttingBranchAndBoundSolution());
//		branchAndBoundAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
//		branchAndBoundAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);
//		
	//	context = new RodCuttingContext(new RodCuttingDivideAndConquerSolution());
	//	divideAndConquerAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
	//	divideAndConquerAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);
	}



	public RodCuttingContext getContext() {
		return context;
	}



	public double getGreedyAlgorithmMaximumRevenue() {
		return greedyAlgorithmMaximumRevenue;
	}



	public double getDynamicAlgorithmMaximumRevenue() {
		return dynamicAlgorithmMaximumRevenue;
	}



	public double getBranchAndBoundAlgorithmMaximumRevenue() {
		return branchAndBoundAlgorithmMaximumRevenue;
	}



	public double getDivideAndConquerAlgorithmMaximumRevenue() {
		return divideAndConquerAlgorithmMaximumRevenue;
	}



	public ArrayList<Rod> getGreedyAlgorithmMaximumRevenueRodList() {
		return greedyAlgorithmMaximumRevenueRodList;
	}



	public ArrayList<Rod> getDynamicAlgorithmMaximumRevenueRodList() {
		return dynamicAlgorithmMaximumRevenueRodList;
	}



	public ArrayList<Rod> getBranchAndBoundAlgorithmMaximumRevenueRodList() {
		return branchAndBoundAlgorithmMaximumRevenueRodList;
	}



	public ArrayList<Rod> getDivideAndConquerAlgorithmMaximumRevenueRodList() {
		return divideAndConquerAlgorithmMaximumRevenueRodList;
	}
}
