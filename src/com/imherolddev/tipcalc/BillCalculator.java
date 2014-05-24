package com.imherolddev.tipcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class BillCalculator {
	
	private BigDecimal tipTotal;
	private BigDecimal billTotal;
	private final BigDecimal PERCENT = new BigDecimal("100");
	private NumberFormat format = NumberFormat.getCurrencyInstance();
	
	public void calcBill(String bill, String tip) {
		
		BigDecimal billAmt = new BigDecimal(bill);
		BigDecimal tipPercent = new BigDecimal(tip);
		tipTotal = billAmt.multiply(tipPercent.divide(PERCENT));
		
		billTotal = billAmt.add(tipTotal);

		
	}
	
	public String roundUp() {
		
		BigDecimal roundTotal = this.billTotal.setScale(0, RoundingMode.CEILING);
		
		tipTotal = tipTotal.add(roundTotal).subtract(billTotal);
		
		return format.format(Double.parseDouble(roundTotal.toString()));
		
	}
	
	public String getTipTotal() {
		
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		
		return format.format(Double.parseDouble(tipTotal.setScale(2, RoundingMode.HALF_EVEN).toString()));
	
	}
	
	public String getBillTotal() {
		
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		
		return format.format(Double.parseDouble(billTotal.setScale(2, RoundingMode.HALF_EVEN).toString()));
		
	}

}
