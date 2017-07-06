package com.hanbit.account.service;

import java.util.Vector;

import com.hanbit.account.domain.AccountBean;

public interface AccountService {
	//setter
	public void addAccount(AccountBean bean);
	public void updatePW(AccountBean bean);
	public void updateDeposit(AccountBean bean);	//입금액
	public void updateAmount(AccountBean bean);		//출금액
	public void deleteAccount(int accountNum);
	
	//getter
	public int countAccount();
	public AccountBean findByAccount(int account);
	public Vector<AccountBean> findByName(String name);
	public Vector<AccountBean> accountList();
}
