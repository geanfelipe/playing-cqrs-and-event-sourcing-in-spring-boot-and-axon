
package com.gean.demo.exception;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5061815641057020106L;

	public AccountNotFoundException(final UUID id) {
		super("Cannot found account number [" + id + "]");
	}

}
