package com.rodcut.test;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;




import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingModel;

public class RodCuttingTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Rod> rodList1 = new ArrayList<Rod>();
		int index = 0;
		rodList1.add(new Rod(index++, 1, 1));
		rodList1.add(new Rod(index++, 2, 6));
		rodList1.add(new Rod(index++, 3, 3));
		rodList1.add(new Rod(index++, 4, 4));
		
		int totalLength = 11;
		RodCuttingModel model = new RodCuttingModel(totalLength, rodList1);

//		Calendar cal;
//		long start;
//		long end;
//		
//		//start = Calendar.getInstance().getTimeInMillis();
		System.out.println("Greedy Algorithm Maximum Revenue : " + model.getGreedyAlgorithmMaximumRevenue());
//		//end = Calendar.getInstance().getTimeInMillis();
//		//System.out.println(end - start);
//		
//		//start = Calendar.getInstance().getTimeInMillis();
		System.out.println("Dynamic Programming Algorithm Maximum Revenue : " + model.getDynamicAlgorithmMaximumRevenue());
//		end = Calendar.getInstance().getTimeInMillis();
//		System.out.println(end - start);
//		
//		start = Calendar.getInstance().getTimeInMillis();
//		System.out.println("Branch And Bound Algorithm Maximum Revenue : " + model.getBranchAndBoundAlgorithmMaximumRevenue());
//		end = Calendar.getInstance().getTimeInMillis();
//		System.out.println(end - start);
		
		// System.out.println("Divide And Conquer Algorithm Maximum Revenue : " + model.getDivideAndConquerAlgorithmMaximumRevenue());
	}
}
