package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;


import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountService {
	public void openAccount(Account account) {
		AccountDao dao = new AccountDao();
		dao.add(account);
		// emailService.sendEmail(...)
	}

	public void withdraw(int acno, double amount) {
		AccountDao dao = new AccountDao();
		Account acc = dao.fetch(Account.class, acno);

		if (acc.getBalance() >= amount) {
			acc.setBalance(acc.getBalance() - amount);
		}
		
		dao.add(acc);
		
		Transaction tx = new Transaction();
		tx.setAccount(acc);
		tx.setDataAndTime(LocalDateTime.now());
		tx.setAmount(amount);
		tx.setTx_type("WITHDRAW");
		
		dao.add(tx);
	}

	public void deposit(int acno, double amount) {
		AccountDao dao = new AccountDao();
		Account acc = dao.fetch(Account.class, acno);

		acc.setBalance(acc.getBalance() + amount);
		dao.add(acc);
		
		Transaction tx = new Transaction();
		tx.setAccount(acc);
		tx.setDataAndTime(LocalDateTime.now());
		tx.setAmount(amount);
		tx.setTx_type("DEPOSIT");
		
		dao.add(tx);
	}

	public void transfer(int fromAcno, int toAcno, double amount) {
		withdraw(fromAcno, amount);
		deposit(toAcno, amount);
	}

	public double balance(int acno) {
		AccountDao dao = new AccountDao();
		Account acc = dao.fetch(Account.class, acno);
		return acc.getBalance();
	}

	public List<Transaction> miniStatement(int acno) {
		AccountDao dao = new AccountDao();
		List<Transaction> list = dao.fetchMiniStatement(acno);
		return list;
	}
}
