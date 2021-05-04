
package com.gean.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gean.demo.entity.BankAccount;
import com.gean.demo.service.AccountQueryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Bank Account Queries", description = "Bank Account Query Events API")
public class AccountQueryController {

	@Autowired
	private AccountQueryService accountQueryService;

	@GetMapping("/{accountId}")
	public CompletableFuture<BankAccount> findById(@PathVariable("accountId") final String accountId) {
		return accountQueryService.findById(accountId);
	}

	@GetMapping("/{accountId}/events")
	public List<Object> listEventsForAccount(@PathVariable(value = "accountId") final String accountId) {
		return accountQueryService.listEventsForAccount(accountId);
	}
}
