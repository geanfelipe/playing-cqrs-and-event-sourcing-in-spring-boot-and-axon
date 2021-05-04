
package com.gean.demo.query;

import java.util.UUID;

public class FindBankAccountQuery {
	private UUID accountId;

	public FindBankAccountQuery() {}

	public FindBankAccountQuery(final UUID accountId) {
		super();
		this.accountId = accountId;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(final UUID accountId) {
		this.accountId = accountId;
	}

}
