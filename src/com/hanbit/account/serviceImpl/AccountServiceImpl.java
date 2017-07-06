package com.hanbit.account.serviceImpl;

import java.util.Calendar;
import java.util.Vector;
import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;

public class AccountServiceImpl implements AccountService{

	Vector<AccountBean> vec;
	public AccountServiceImpl() {
		vec = new Vector<AccountBean>(10,10);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDeposit(AccountBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAmount(AccountBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(int accountNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countAccount() {	//전체계좌수
		return vec.size();
	}

	@Override
	public AccountBean findByAccount(int account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<AccountBean> findByName(String name) {
		// TODO Auto-generated method stub
		Vector<AccountBean> temp = new Vector<AccountBean>(10,10);
		for(int i=0;i<10/*???*/;i++){
			//if(get(i).getName.eq......)
		}
		return temp;
	}

	@Override
	public Vector<AccountBean> accountList() {	//계좌전체목록
		return vec;
	}

}
