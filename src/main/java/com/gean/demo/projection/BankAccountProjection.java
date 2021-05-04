
package com.gean.demo.projection;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gean.demo.entity.BankAccount;
import com.gean.demo.event.AccountCreatedEvent;
import com.gean.demo.event.MoneyCreditedEvent;
import com.gean.demo.event.MoneyDebitedEvent;
import com.gean.demo.exception.AccountNotFoundException;
import com.gean.demo.query.FindBankAccountQuery;
import com.gean.demo.repository.BankAccountRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BankAccountProjection {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountProjection.class);

	@Autowired
	private BankAccountRepository repository;

	@EventHandler
	public void on(final AccountCreatedEvent event) {
		LOGGER.info("$$$$ Handling a Bank Account creation command {}", event.getId());
		final BankAccount bankAccount =
		        new BankAccount(event.getId().toString(), event.getOwner(), event.getInitialBalance());
		repository.save(bankAccount);
	}

	@EventHandler
	public void on(final MoneyCreditedEvent event) throws AccountNotFoundException {
		LOGGER.info("$+++ Handling an Account Credit command {}", event.getId());
		final Optional<BankAccount> optionalBankAccount = repository.findById(event.getId().toString());
		if (optionalBankAccount.isPresent()) {
			final BankAccount bankAccount = optionalBankAccount.get();
			bankAccount.setBalance(bankAccount.getBalance().add(event.getCreditAmount()));
			repository.save(bankAccount);
		} else {
			throw new AccountNotFoundException(event.getId());
		}
	}

	@EventHandler
	public void on(final MoneyDebitedEvent event) throws AccountNotFoundException {
		LOGGER.info("$--- Handling an Account Debit command {}", event.getId());
		final Optional<BankAccount> optionalBankAccount = repository.findById(event.getId().toString());
		if (optionalBankAccount.isPresent()) {
			final BankAccount bankAccount = optionalBankAccount.get();
			bankAccount.setBalance(bankAccount.getBalance().subtract(event.getDebitAmount()));
			repository.save(bankAccount);
		} else {
			throw new AccountNotFoundException(event.getId());
		}
	}

	@QueryHandler
	public BankAccount handle(final FindBankAccountQuery query) {
		LOGGER.info(".... Handling FindBankAccountQuery query: {}", query);
		return repository.findById(query.getAccountId().toString()).orElse(null);
	}
}
