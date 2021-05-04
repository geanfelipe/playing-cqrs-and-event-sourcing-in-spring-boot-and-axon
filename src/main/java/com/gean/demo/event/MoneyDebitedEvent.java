
package com.gean.demo.event;

import java.math.BigDecimal;
import java.util.UUID;

public class MoneyDebitedEvent {

	private UUID id;
	private BigDecimal debitAmount;

	public MoneyDebitedEvent() {}

	public MoneyDebitedEvent(final UUID id, final BigDecimal debitAmount) {
		super();
		this.id = id;
		this.debitAmount = debitAmount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(final BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

}
