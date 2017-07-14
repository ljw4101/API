package com.hanbit.account.controller;

import com.hanbit.account.serviceImpl.ATMServiceImpl;

//스레드 사용
public class ATMController {
	public static void main(String[] args){
		ATMServiceImpl.ATM atm = new ATMServiceImpl.ATM();	//static 선언으로 인해 가능
		
		//Runnable: 대기상태
		Runnable kim = new ATMServiceImpl(atm, "kim");
		Runnable hong = new ATMServiceImpl(atm, "hong");
		Runnable cho = new ATMServiceImpl(atm, "cho");
		
		Thread th1 = new Thread(kim);
		Thread th2 = new Thread(hong);
		Thread th3 = new Thread(cho);
		
		//run은 직접 실행시키는 것이 아님
		th1.start();
		th2.start();
		th3.start();
		
		/* 다형성 : Runnable r = new ATMServiceImpl(); 시 오류발생
		 * 다형성X: ATMServiceImpl r = new ATMServiceImpl(); 시 오류 X
		 * 2. r.abc();
		 * */
	}
}
