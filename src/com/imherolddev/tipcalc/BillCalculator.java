package com.imherolddev.tipcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class BillCalculator {
	
	private BigDecimal tipTotal;
	private BigDecimal billTotal;
	private final BigDecimal PERCENT = new BigDecimal("100");
	NumberFormat format = NumberFormat.getCurrencyInstance();
	BigDecimal tipDisplay;
	
	
	public String calcBill(String bill, String tip) {
		
		BigDecimal billAmt = new BigDecimal(bill);
		BigDecimal tipPercent = new BigDecimal(tip);
		tipTotal = billAmt.multiply(tipPercent.divide(PERCENT));
		
		billTotal = billAmt.add(tipTotal);
		
		BigDecimal billDisplay = billTotal.setScale(2, RoundingMode.HALF_EVEN);
		tipDisplay = tipTotal.setScale(2, RoundingMode.HALF_EVEN);
		
		format.setMinimumFractionDigits(1);
		format.setMaximumFractionDigits(2);
		
		return format.format(Double.parseDouble(billDisplay.toString()));
		
	}
	
	public double roundUp(double total) {
		
		int newTotal = 0;
		
		return newTotal;
		
	}
	
	public String getTipTotal() {
		
		return format.format(Double.parseDouble(this.tipDisplay.toString()));
		
	}

}
