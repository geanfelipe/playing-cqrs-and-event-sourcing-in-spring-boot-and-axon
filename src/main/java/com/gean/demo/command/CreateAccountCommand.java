
package com.gean.demo.command;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateAccountCommand {

	@TargetAggregateIdentifier
	private UUID accountId;
	private BigDecimal initialBalance;
	private String owner;

	public CreateAccountCommand() {}

	public CreateAccountCommand(final UUID accountId, final BigDecimal initialBalance, final String owner) {
		super();
		this.accountId = accountId;
		this.initialBalance = initialBalance;
		this.owner = owner;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(final UUID accountId) {
		this.accountId = accountId;
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
