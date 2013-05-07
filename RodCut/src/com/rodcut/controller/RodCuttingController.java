package com.rodcut.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.rodcut.model.RodCuttingModel;
import com.rodcut.view.RodCuttingView;

public class RodCuttingController implements ActionListener {

	private RodCuttingModel model;
	private RodCuttingView view;

	public RodCuttingController(RodCuttingModel m, RodCuttingView v) {
		model = m;
		view = v;
	}

	public void actionPerformed(ActionEvent ae) {
		
		/* TO DO: update myModel.state, catch bad inputs */

		// say something here like (if ae.getActionCommand.equals("hitting enter ...");
		try {
			if ("addRodBtn".equals(ae.getActionCommand())) {
				int length = Integer.parseInt(view.getLengthText());
				double price = Double.parseDouble(view.getPriceText());
				model.createRod(length, price);
				System.out.println("CLICKED");
		    } 
			else  {
				JTextField field = (JTextField) ae.getSource();
				String a = field.getText();
				Integer nextState = Integer.parseInt(a);
				model.setState(nextState);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "You are in actionperformed", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}