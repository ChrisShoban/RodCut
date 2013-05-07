package com.rodcut.test;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingModel;
import com.rodcut.view.RodCuttingView;

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
		printWithTime("Greedy Algorithm Maximum Revenue : " , model.getGreedyAlgorithmMaximumRevenue());
		printWithTime("Dynamic Programming Algorithm Maximum Revenue : ", model.getDynamicAlgorithmMaximumRevenue());
		printWithTime("Branch And Bound Algorithm Maximum Revenue : ",  model.getBranchAndBoundAlgorithmMaximumRevenue());
		
		JFrame gui = new JFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Rod Cutting");
		gui.add(new RodCuttingView(new RodCuttingModel()));
		gui.setPreferredSize(new Dimension(800, 500));
		gui.pack();
		gui.setVisible(true);
		
		

		/*
		 * myModel.addObserver(this); 
		 * newState.addActionListener(myController); 
		 * JTextField field = (JTextField)ae.getSource(); // get's the source typed into the Textfield
		 */
	}
	
	private static void printWithTime(String text, double revenue) {
		//long start = Calendar.getInstance().getTimeInMillis();
		//System.out.println(start);
		System.out.println(text + revenue);
		//long end = Calendar.getInstance().getTimeInMillis();
		//System.out.println(end);
		//System.out.println("TIME TAKEN : " + (end - start));
	}
}
