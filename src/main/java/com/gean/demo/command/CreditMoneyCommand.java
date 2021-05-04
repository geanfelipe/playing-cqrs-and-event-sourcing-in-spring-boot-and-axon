
package com.gean.demo.command;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreditMoneyCommand {
	@TargetAggregateIdentifier
	private UUID accountId;
	private BigDecimal creditAmount;

	public CreditMoneyCommand() {}

	public CreditMoneyCommand(final UUID accountId, final BigDecimal creditAmount) {
		super();
		this.accountId = accountId;
		this.creditAmount = creditAmount;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(final UUID accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(final BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

}
