
package com.gean.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gean.demo.dto.AccountCreationDTO;
import com.gean.demo.dto.MoneyAmountDTO;
import com.gean.demo.entity.BankAccount;
import com.gean.demo.service.AccountCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Bank Account Commands", description = "Bank Account Commands API")
public class AccountCommandController {

	@Autowired
	private AccountCommandService accountCommandService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CompletableFuture<BankAccount> createAccount(@RequestBody final AccountCreationDTO creationDTO) {
		return accountCommandService.createAccount(creationDTO);
	}

	@PutMapping(value = "/credit/{accountId}")
	public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountId") final String accountId,
	        @RequestBody final MoneyAmountDTO moneyCreditDTO) {
		return accountCommandService.creditMoneyToAccount(accountId, moneyCreditDTO);
	}

	@PutMapping(value = "/debit/{accountId}")
	public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountId") final String accountId,
	        @RequestBody final MoneyAmountDTO moneyDebitDTO) {
		return accountCommandService.debitMoneyFromAccount(accountId, moneyDebitDTO);
	}

}
