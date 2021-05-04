
package com.gean.demo.event;

import java.math.BigDecimal;
import java.util.UUID;

public class MoneyCreditedEvent {

	private UUID id;
	private BigDecimal creditAmount;

	public MoneyCreditedEvent() {}

	public MoneyCreditedEvent(final UUID id, final BigDecimal creditAmount) {
		super();
		this.id = id;
		this.creditAmount = creditAmount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(final BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

}
