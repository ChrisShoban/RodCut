package com.rodcut.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.rodcut.controller.RodCuttingController;
import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingModel;

public class RodCuttingView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private RodCuttingModel model;
	private RodCuttingController myController;
	private JTextField newState, price, length;
	private JLabel aNewState, currentState, priceLabel, lengthLabel, currentRods;
	private JButton addRodBtn;

	public RodCuttingView(RodCuttingModel m) {
		this.setPreferredSize(new Dimension(200, 200));
		this.setLayout(new FlowLayout());
		model = m;
		myController = new RodCuttingController(model, this);
		aNewState = new JLabel("new state =\t");
		newState = new JTextField(10);
		newState.setActionCommand("newState");
		newState.addActionListener(myController);

		currentState = new JLabel("current state =\t");
		// wire components:
		//add(aNewState);
		//add(newState);
		//add(currentState);		
		
		addLengthLabel();
		addPriceLabel();
		addRodBtn();
		currentRods();
		
		
		model.addObserver(this);
	}
	
	private void currentRods() {
		currentRods = new JLabel("ABC");
		add(currentRods);
	}
	

	private void addLengthLabel() {
		lengthLabel = new JLabel("Length : ");
		length = new JTextField(10);
		length.setActionCommand("length");
		add(lengthLabel);
		add(length);
	}
	
	public String getPriceText() {
		return price.getText();
	}
	
	public String getLengthText() {
		return length.getText();
	}
	
	private void addPriceLabel() {
		priceLabel = new JLabel("Price : ");
		price = new JTextField(10);
		price.setActionCommand("price");
		add(priceLabel);
		add(price);
	}
	
	private void addRodBtn() {
		addRodBtn = new JButton("ADD ROD");
		addRodBtn.setActionCommand("addRodBtn");
		addRodBtn.addActionListener(myController);
		add(addRodBtn);
	}

	public void update(Observable m, Object msg) {
		if (m instanceof RodCuttingModel) {
			
			String txt = "aa";
			
			ArrayList<Rod> rods = model.getRodList();
			for(Rod rod : rods) {
				System.out.println(rods.size());
				txt = rod.getLength() + " " + rod.getPrice();
			}
			System.out.println(txt);
			// newState = new JTextField("");
			// add(newState);
			currentRods.setText(txt);
			// add(currentState);
			// repaint();
		}
	}
}