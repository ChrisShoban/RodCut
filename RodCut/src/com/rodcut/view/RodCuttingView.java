package com.rodcut.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
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
	private JTextField price, length;
	private JLabel priceLabel, lengthLabel, currentRods;
	private JButton addRodBtn;
	private JPanel inputRodTable;

	public RodCuttingView(RodCuttingModel m) {
		this.setPreferredSize(new Dimension(200, 200));
		this.setLayout(new FlowLayout());
		model = m;
		myController = new RodCuttingController(model, this);
		addLengthLabel();
		addPriceLabel();
		addRodBtn();
		currentRods();
		model.addObserver(this);
	}

	private void currentRods() {
		currentRods = new JLabel("CURRENT ROD LIST");
		add(currentRods);
		inputRodTable = new JPanel();
		inputRodTable.setLayout(new GridLayout(1,1));
		inputRodTable.add(new Label( "a"));
        add(inputRodTable);
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
			ArrayList<Rod> rods = model.getRodList();
			int numberOfRows = (int) Math.ceil((double)rods.size()/2);
			inputRodTable.setLayout(new GridLayout(numberOfRows,2));
			for (Rod rod : rods) {
				inputRodTable = new JPanel();
				inputRodTable.add(new Label(rod.getLength() + ""));
				inputRodTable.add(new Label(rod.getPrice() + ""));
			}
		}
		repaint();
	}
}