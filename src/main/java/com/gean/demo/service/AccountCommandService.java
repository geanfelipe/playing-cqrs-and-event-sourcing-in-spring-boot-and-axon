
package com.gean.demo.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gean.demo.command.CreateAccountCommand;
import com.gean.demo.command.CreditMoneyCommand;
import com.gean.demo.command.DebitMoneyCommand;
import com.gean.demo.dto.AccountCreationDTO;
import com.gean.demo.dto.MoneyAmountDTO;
import com.gean.demo.entity.BankAccount;

@Component
public class AccountCommandService {

	@Autowired
	private CommandGateway commandGateway;

	public CompletableFuture<BankAccount> createAccount(final AccountCreationDTO creationDTO) {
		return commandGateway.send(
		        new CreateAccountCommand(UUID.randomUUID(), creationDTO.getInitialBalance(), creationDTO.getOwner()));
	}

	public CompletableFuture<String> creditMoneyToAccount(final String accountId, final MoneyAmountDTO moneyCreditDTO) {
		return commandGateway.send(new CreditMoneyCommand(UUID.fromString(accountId), moneyCreditDTO.getAmount()));
	}

	public CompletableFuture<String> debitMoneyFromAccount(final String accountId, final MoneyAmountDTO moneyDebitDTO) {
		return commandGateway.send(new DebitMoneyCommand(UUID.fromString(accountId), moneyDebitDTO.getAmount()));
	}
}
