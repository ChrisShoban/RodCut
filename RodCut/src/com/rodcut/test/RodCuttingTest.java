package com.rodcut.test;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;

import com.rodcut.model.RodCuttingModel;

public class RodCuttingTest {
	
	public static void main(String[] args) throws InterruptedException {
		int totalLength = 4;
		ArrayList<Double> prices = new ArrayList<Double>();
		prices.add(1.0);
		prices.add(6.0);
		prices.add(3.0);
		prices.add(4.0);
		RodCuttingModel model = new RodCuttingModel(totalLength, prices);

//		Calendar cal;
//		long start;
//		long end;
//		
//		//start = Calendar.getInstance().getTimeInMillis();
//		System.out.println("Greedy Algorithm Maximum Revenue : " + model.getGreedyAlgorithmMaximumRevenue());
//		//end = Calendar.getInstance().getTimeInMillis();
//		//System.out.println(end - start);
//		
//		//start = Calendar.getInstance().getTimeInMillis();
		//System.out.println("Dynamic Programming Algorithm Maximum Revenue : " + model.getDynamicAlgorithmMaximumRevenue());
//		end = Calendar.getInstance().getTimeInMillis();
//		System.out.println(end - start);
//		
//		start = Calendar.getInstance().getTimeInMillis();
		System.out.println("Branch And Bound Algorithm Maximum Revenue : " + model.getBranchAndBoundAlgorithmMaximumRevenue());
//		end = Calendar.getInstance().getTimeInMillis();
//		System.out.println(end - start);
		
		// System.out.println("Divide And Conquer Algorithm Maximum Revenue : " + model.getDivideAndConquerAlgorithmMaximumRevenue());
	}
}
