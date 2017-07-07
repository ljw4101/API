package com.hanbit.account.serviceImpl;

import java.util.Calendar;
import java.util.Vector;
import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;

public class AccountServiceImpl implements AccountService{

	Vector<AccountBean> vec;
	AccountBean accBean;
	
	public AccountServiceImpl() {
		vec = new Vector<AccountBean>(10,10);
		accBean = new AccountBean();
	}
	
	@Override
	public void addAccount(AccountBean bean) {	//계좌계설
		//calendar 거래일자
		Calendar now = Calendar.getInstance();
		int yy = now.get(now.YEAR);
		int mm = now.get(now.MONTH)+1;
		int dd = now.get(now.DAY_OF_MONTH);
		String regDate = yy+"-"+mm+"-"+dd;
		
		//random 계좌번호
		int randomNo = (int)(Math.random()*99999999+10000000);
		
		bean.setRegDate(regDate);
		bean.setAccountNum(randomNo);
		vec.add(bean);
		
		System.out.println(bean.toString());
	}

	@Override
	public void updatePW(AccountBean bean) {
		// 비밀번호 변경
		accBean = findByAccount(bean.getAccountNum());
		accBean.setPw(bean.getPw());
	}

	@Override
	public void updateDeposit(AccountBean bean) {
		//예금
		accBean = findByAccount(bean.getAccountNum());
		accBean.setMoney(accBean.getMoney()+bean.getMoney());
	}

	@Override
	public void updateAmount(AccountBean bean) {
		//출금
		accBean = findByAccount(bean.getAccountNum());
		accBean.setMoney(accBean.getMoney()-bean.getMoney());
		
		System.out.println(accBean.toString());
	}

	@Override
	public void deleteAccount(int accountNum) {
		// 계좌 해지
		if(vec.contains(accountNum)){
			vec.remove(accountNum);
		}
	}

	@Override
	public int countAccount() {	//전체계좌수
		return vec.size();
	}

	@Override
	public AccountBean findByAccount(int account) {
		// 계좌번호조회
		AccountBean temp = new AccountBean();
		for(int i=0; i<vec.size(); i++){
			if(account == vec.get(i).getAccountNum()){
				temp = vec.get(i);
			}
		}
		return temp;
	}

	@Override
	public Vector<AccountBean> findByName(String name) {
		// 이름검색(동명이인허용)
		Vector<AccountBean> temp = new Vector<AccountBean>(10,10);
		for(int i=0; i<vec.size(); i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public Vector<AccountBean> accountList() {	//계좌전체목록
		return vec;
	}

}
