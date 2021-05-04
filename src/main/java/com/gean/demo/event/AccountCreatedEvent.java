
package com.gean.demo.event;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountCreatedEvent {

	private UUID id;
	private BigDecimal initialBalance;
	private String owner;

	public AccountCreatedEvent() {}

	public AccountCreatedEvent(final UUID id, final BigDecimal initialBalance, final String owner) {
		super();
		this.id = id;
		this.initialBalance = initialBalance;
		this.owner = owner;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
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
