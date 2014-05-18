package com.imherolddev.tipcalc;

public class BillCalculator {
	
	private double totalBill = 0.00;
	private int tipTotal = 0;
	
	public double calc(double bill, int tipPercent) {
		
		tipTotal = (int) (bill * (double)(tipPercent / 100));
		totalBill = bill + tipTotal;
		
		return totalBill;
		
	}
	
	public double roundUp(double total) {
		
		int newTotal = 0;
		
		return newTotal;
		
	}

}
