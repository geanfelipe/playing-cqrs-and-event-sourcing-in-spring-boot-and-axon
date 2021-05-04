
package com.gean.demo.command;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DebitMoneyCommand {
	@TargetAggregateIdentifier
	private UUID accountId;
	private BigDecimal debitAmount;

	public DebitMoneyCommand() {}

	public DebitMoneyCommand(final UUID accountId, final BigDecimal debitAmount) {
		super();
		this.accountId = accountId;
		this.debitAmount = debitAmount;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(final UUID accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(final BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

}
