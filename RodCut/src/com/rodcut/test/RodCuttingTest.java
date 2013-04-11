package com.rodcut.test;

import java.util.ArrayList;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingContext;
import com.rodcut.solutions.RodCuttingBranchAndBoundSolution;
import com.rodcut.solutions.RodCuttingDivideAndConquerSolution;
import com.rodcut.solutions.RodCuttingDynamicSolution;
import com.rodcut.solutions.RodCuttingGreedySolution;

public class RodCuttingTest {
	
	public static void main(String[] args) {
		RodCuttingContext context;

		int totalLength = 24;
		ArrayList<Integer> prices = new ArrayList<Integer>();
		
		context = new RodCuttingContext(new RodCuttingGreedySolution());
		Rod resultA = context.executeStrategy(totalLength, prices);

		context = new RodCuttingContext(new RodCuttingDynamicSolution());
		Rod resultB = context.executeStrategy(totalLength, prices);

		context = new RodCuttingContext(new RodCuttingBranchAndBoundSolution());
		Rod resultC = context.executeStrategy(totalLength, prices);
		
		context = new RodCuttingContext(new RodCuttingDivideAndConquerSolution());
		Rod resultD = context.executeStrategy(totalLength, prices);

		System.out.println("Result A : " + resultA.getMaximumRevenue());
		System.out.println("Result B : " + resultB.getMaximumRevenue());
		System.out.println("Result C : " + resultC.getMaximumRevenue());
		System.out.println("Result D : " + resultD.getMaximumRevenue());

	}
}
