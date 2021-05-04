
package com.gean.demo.exception;

import java.math.BigDecimal;
import java.util.UUID;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = -2728446167772316348L;

	public InsufficientBalanceException(final UUID accountId, final BigDecimal amount) {
		super("Insufficient Balance: Cannot debit " + amount + " from account number [" + accountId.toString() + "]");
	}

}
