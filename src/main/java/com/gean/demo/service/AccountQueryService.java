
package com.gean.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gean.demo.entity.BankAccount;
import com.gean.demo.query.FindBankAccountQuery;

@Component
public class AccountQueryService {

	@Autowired
	private QueryGateway queryGateway;

	@Autowired
	private EventStore eventStore;

	public CompletableFuture<BankAccount> findById(final String accountId) {
		return queryGateway.query(new FindBankAccountQuery(UUID.fromString(accountId)),
		        ResponseTypes.instanceOf(BankAccount.class));
	}

	public List<Object> listEventsForAccount(final String accountId) {
		return eventStore.readEvents(UUID.fromString(accountId).toString())
		        .asStream()
		        .map(Message::getPayload)
		        .collect(Collectors.toList());
	}
}
