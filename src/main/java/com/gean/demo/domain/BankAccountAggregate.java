
package com.gean.demo.domain;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.gean.demo.command.CreateAccountCommand;
import com.gean.demo.command.CreditMoneyCommand;
import com.gean.demo.command.DebitMoneyCommand;
import com.gean.demo.event.AccountCreatedEvent;
import com.gean.demo.event.MoneyCreditedEvent;
import com.gean.demo.event.MoneyDebitedEvent;
import com.gean.demo.exception.InsufficientBalanceException;

@Aggregate // The annotation informs Axon’s auto configurer for Spring that this
           // class is an Aggregate instance.
public class BankAccountAggregate {

	@AggregateIdentifier // 2
	private UUID id;
	private BigDecimal balance;
	private String owner;

	@CommandHandler
	public BankAccountAggregate(final CreateAccountCommand command) {
		AggregateLifecycle.apply(
		        new AccountCreatedEvent(command.getAccountId(), command.getInitialBalance(), command.getOwner()));
	}

	@EventSourcingHandler
	public void on(final AccountCreatedEvent event) {
		id = event.getId();
		owner = event.getOwner();
		balance = event.getInitialBalance();
	}

	@CommandHandler
	public void handle(final CreditMoneyCommand command) {
		System.out.println("Aggregate CreditMoneyCommand: " + command.getCreditAmount());
		AggregateLifecycle.apply(new MoneyCreditedEvent(command.getAccountId(), command.getCreditAmount()));
	}

	@EventSourcingHandler
	public void on(final MoneyCreditedEvent event) {
		System.out.println("Aggregate MoneyCreditedEvent: " + event.getCreditAmount());
		balance = balance.add(event.getCreditAmount());
	}

	@CommandHandler
	public void handle(final DebitMoneyCommand command) {
		System.out.println("Aggregate DebitMoneyCommand: " + command.getDebitAmount());
		AggregateLifecycle.apply(new MoneyDebitedEvent(command.getAccountId(), command.getDebitAmount()));
	}

	@EventSourcingHandler
	public void on(final MoneyDebitedEvent event) throws InsufficientBalanceException {
		System.out.println("Aggregate MoneyDebitedEvent: " + event.getDebitAmount());
		if (balance.compareTo(event.getDebitAmount()) < 0) {
			throw new InsufficientBalanceException(event.getId(), event.getDebitAmount());
		}
		balance = balance.subtract(event.getDebitAmount());
	}

	public BankAccountAggregate() {}

	public BankAccountAggregate(final UUID id, final BigDecimal balance, final String owner) {
		super();
		this.id = id;
		this.balance = balance;
		this.owner = owner;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(final BigDecimal balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(final String owner) {
		this.owner = owner;
	}

}
