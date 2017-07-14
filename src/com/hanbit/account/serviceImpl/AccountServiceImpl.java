package com.hanbit.account.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;

public class AccountServiceImpl implements AccountService{

	List<AccountBean> vec;

	public AccountServiceImpl() {
		vec = new ArrayList<AccountBean>(); //다형성으로 ArrayList, Vector, Stack 선언 가능
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
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountNum()==vec.get(i).getAccountNum()){
				vec.get(i).setPw(bean.getPw());
				System.out.println(vec.get(i).toString());
				break;
			}
		}
		
		
	}

	@Override
	public void updateDeposit(AccountBean bean) {
		//예금
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountNum() == vec.get(i).getAccountNum()){
				System.out.println(i+"/"+vec.get(i).getMoney()+"//"+bean.getMoney());
				
				vec.get(i).setMoney(vec.get(i).getMoney()+bean.getMoney());
				System.out.println("예금: "+vec.get(i).toString());
				break;
			}
		}
	}

	@Override
	public void updateAmount(AccountBean bean) {
		//출금
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountNum() == vec.get(i).getAccountNum()){
				vec.get(i).setMoney(vec.get(i).getMoney()-bean.getMoney());
				System.out.println("출금: "+vec.get(i).toString());
				break;
			}
		}
	}

	@Override
	public void deleteAccount(int accountNum) {
		// 계좌 해지
		for(int i=0;i<vec.size();i++){
			if(accountNum == vec.get(i).getAccountNum()){
				vec.remove(i);
				break;
			}
		}
		
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
	public List<AccountBean> findByName(String name) {
		// 이름검색(동명이인허용)
		//이름 검색에 대한 결과물은 전체보다 작으므로 새로 선언
		Vector<AccountBean> temp = new Vector<AccountBean>(10,10);	
		for(int i=0; i<vec.size(); i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public List<AccountBean> accountList() {	//계좌전체목록
		return vec;
	}

	@Override
	public String checkRestMoney(AccountBean bean) {
		String message = "";
		
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountNum() == vec.get(i).getAccountNum()){
				if(bean.getMoney() < vec.get(i).getMoney()){
					updateAmount(bean);		//출금
					message = "예금완료";
					break;
				}else{
					message = "잔액이 부족합니다. 잔액: "+vec.get(i).getMoney()+"원";
				}
				break;
			}
		}
		return message;
	}
}