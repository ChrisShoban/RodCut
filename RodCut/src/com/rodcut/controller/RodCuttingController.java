package com.rodcut.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		try {
			if ("addRodBtn".equals(ae.getActionCommand())) {
				int length = Integer.parseInt(view.getLengthText());
				double price = Double.parseDouble(view.getPriceText());
				model.createRod(length, price);
		    }
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Enter valid input", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "You are in actionperformed", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}