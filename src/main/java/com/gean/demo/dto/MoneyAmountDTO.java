
package com.gean.demo.dto;

import java.math.BigDecimal;

public class MoneyAmountDTO {

	private BigDecimal amount;

	public MoneyAmountDTO() {}

	public MoneyAmountDTO(final BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

}
