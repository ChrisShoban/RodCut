package com.rodcut.model;

import java.util.ArrayList;

import com.rodcut.model.solutions.RodCuttingBranchAndBoundSolution;
import com.rodcut.model.solutions.RodCuttingDynamicSolution;
import com.rodcut.model.solutions.RodCuttingGreedySolution;

public class RodCuttingModel {

	private ArrayList<Rod> rods;

	private int currentIndex = 0;

	private RodCuttingContext context;

	private double greedyAlgorithmMaximumRevenue;

	private double dynamicAlgorithmMaximumRevenue;

	private double branchAndBoundAlgorithmMaximumRevenue;

	private double divideAndConquerAlgorithmMaximumRevenue;

	private ArrayList<Rod> greedyAlgorithmMaximumRevenueRodList;

	private ArrayList<Rod> dynamicAlgorithmMaximumRevenueRodList;

	private ArrayList<Rod> branchAndBoundAlgorithmMaximumRevenueRodList;

	private ArrayList<Rod> divideAndConquerAlgorithmMaximumRevenueRodList;

	public void createRod(int length, double price) {
		rods.add(new Rod(currentIndex++, length, price));
	}

	public RodCuttingModel() {
		rods = new ArrayList<Rod>();
	}

	public ArrayList<Rod> getRodList() {
		return rods;
	}

	public RodCuttingModel(int totalLength, ArrayList<Rod> rods) {

		context = new RodCuttingContext(new RodCuttingGreedySolution());
		greedyAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, rods);
		greedyAlgorithmMaximumRevenue = RodCuttingCommon.getInstance().getPricesFromRodsStrategy(greedyAlgorithmMaximumRevenueRodList);

		context = new RodCuttingContext(new RodCuttingDynamicSolution());
		dynamicAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, rods);
		dynamicAlgorithmMaximumRevenue = RodCuttingCommon.getInstance().getPricesFromRodsStrategy(dynamicAlgorithmMaximumRevenueRodList);

		context = new RodCuttingContext(new RodCuttingBranchAndBoundSolution());
		branchAndBoundAlgorithmMaximumRevenueRodList = context.getMaximumRevenueRodsStrategy(totalLength, rods);
		branchAndBoundAlgorithmMaximumRevenue = RodCuttingCommon.getInstance().getPricesFromRodsStrategy(branchAndBoundAlgorithmMaximumRevenueRodList);
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
