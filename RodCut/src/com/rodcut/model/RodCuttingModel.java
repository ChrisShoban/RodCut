package com.rodcut.model;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.solutions.RodCuttingBranchAndBoundSolution;
import com.rodcut.model.solutions.RodCuttingDivideAndConquerSolution;
import com.rodcut.model.solutions.RodCuttingDynamicSolution;
import com.rodcut.model.solutions.RodCuttingGreedySolution;

public class RodCuttingModel {
	
	private RodCuttingContext context;
	
	private double greedyAlgorithmMaximumRevenue;
	
	private double dynamicAlgorithmMaximumRevenue;
	
	private double branchAndBoundAlgorithmMaximumRevenue;
	
	private double divideAndConquerAlgorithmMaximumRevenue;
	
	private List<Rod> greedyAlgorithmMaximumRevenueRodList;
	
	private List<Rod> dynamicAlgorithmMaximumRevenueRodList;
	
	private List<Rod> branchAndBoundAlgorithmMaximumRevenueRodList;
	
	private List<Rod> divideAndConquerAlgorithmMaximumRevenueRodList;
	
	
	public RodCuttingModel(int totalLength, ArrayList<Double> prices) {
		
//		context = new RodCuttingContext(new RodCuttingGreedySolution());
//		greedyAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
//		greedyAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);

		//context = new RodCuttingContext(new RodCuttingDynamicSolution());
		//dynamicAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
		//dynamicAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);


		context = new RodCuttingContext(new RodCuttingBranchAndBoundSolution());
		branchAndBoundAlgorithmMaximumRevenue = context.getMaximumRevenueStrategy(totalLength, prices);
		branchAndBoundAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, prices);
		
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



	public List<Rod> getGreedyAlgorithmMaximumRevenueRodList() {
		return greedyAlgorithmMaximumRevenueRodList;
	}



	public List<Rod> getDynamicAlgorithmMaximumRevenueRodList() {
		return dynamicAlgorithmMaximumRevenueRodList;
	}



	public List<Rod> getBranchAndBoundAlgorithmMaximumRevenueRodList() {
		return branchAndBoundAlgorithmMaximumRevenueRodList;
	}



	public List<Rod> getDivideAndConquerAlgorithmMaximumRevenueRodList() {
		return divideAndConquerAlgorithmMaximumRevenueRodList;
	}
}
