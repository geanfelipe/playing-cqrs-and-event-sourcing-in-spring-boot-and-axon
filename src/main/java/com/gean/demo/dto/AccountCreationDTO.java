
package com.gean.demo.dto;

import java.math.BigDecimal;

public class AccountCreationDTO {

	private BigDecimal initialBalance;
	private String owner;

	public AccountCreationDTO() {}

	public AccountCreationDTO(final BigDecimal initialBalance, final String owner) {
		super();
		this.initialBalance = initialBalance;
		this.owner = owner;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(final BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(final String owner) {
		this.owner = owner;
	}

}
