package com.rodcut.test;

import java.util.ArrayList;

import com.rodcut.model.RodCuttingContext;
import com.rodcut.solutions.RodCuttingBranchAndBoundSolution;
import com.rodcut.solutions.RodCuttingDivideAndConquerSolution;
import com.rodcut.solutions.RodCuttingDynamicSolution;
import com.rodcut.solutions.RodCuttingGreedySolution;

public class RodCuttingTest {
	
	public static void main(String[] args) {
		RodCuttingContext context;

		int totalLength = 24;
		ArrayList<Double> prices = new ArrayList<Double>();
		
		context = new RodCuttingContext(new RodCuttingGreedySolution());
		double greedyResult = context.getMaximumRevenueStrategy(totalLength, prices);

		context = new RodCuttingContext(new RodCuttingDynamicSolution());
		double dynamicResult = context.getMaximumRevenueStrategy(totalLength, prices);

		context = new RodCuttingContext(new RodCuttingBranchAndBoundSolution());
		double branchAndBoundResult = context.getMaximumRevenueStrategy(totalLength, prices);
		
		context = new RodCuttingContext(new RodCuttingDivideAndConquerSolution());
		double divideAndConquerResult = context.getMaximumRevenueStrategy(totalLength, prices);

		System.out.println("Greedy Algorithm Maximum Revenue : " + greedyResult);
		System.out.println("Dynamic Programming Algorithm Maximum Revenue : " + dynamicResult);
		System.out.println("Branch And Bound Algorithm Maximum Revenue : " + branchAndBoundResult);
		System.out.println("Divide And Conquer Algorithm Maximum Revenue : " + divideAndConquerResult);
	}
}
