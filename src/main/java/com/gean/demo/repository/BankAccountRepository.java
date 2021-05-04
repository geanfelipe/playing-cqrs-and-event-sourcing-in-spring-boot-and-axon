
package com.gean.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gean.demo.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
