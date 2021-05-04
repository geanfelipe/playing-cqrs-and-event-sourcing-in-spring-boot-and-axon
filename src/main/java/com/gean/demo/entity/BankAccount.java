
package com.gean.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

	@Id
	private String id;
	private String owner;
	private BigDecimal balance;

	public BankAccount() {}

	public BankAccount(final String id, final String owner, final BigDecimal balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(final String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(final BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (balance == null ? 0 : balance.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (owner == null ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BankAccount other = (BankAccount) obj;
		if (balance == null) {
			if (other.balance != null) {
				return false;
			}
		} else if (!balance.equals(other.balance)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (owner == null) {
			if (other.owner != null) {
				return false;
			}
		} else if (!owner.equals(other.owner)) {
			return false;
		}
		return true;
	}

}
