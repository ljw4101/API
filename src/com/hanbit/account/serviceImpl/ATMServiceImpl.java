package com.hanbit.account.serviceImpl;

import java.util.List;
import java.util.Vector;
import com.sun.swing.internal.plaf.synth.resources.synth;

/* 스레드 사용법
 * 1.implements Runnable
 * 2.add unimplements method
 * */
public class ATMServiceImpl implements Runnable{
	ATM atm;
	String name;
	public static List<String> list = new Vector<>();
	
	public ATMServiceImpl(ATM atm, String name){
		this.atm = atm;
		this.name = name;
	}
	
	@Override
	public void run() {
		atm.withdraw(name);
	}
	
	//inner class
	public static class ATM{
		//synchronized: 하나의 객체가 일이 끝날때까지 블럭을 쳐주는 역할
		public synchronized void withdraw(String name){
			System.out.println(name+"이 인출 요청함");
			for(int i=0;i<=100000000;i++){
				if(i==10000){
					System.out.println(name+"이 인출중임..");
				}
			}
			System.out.println(name+"인출해 나감");
		}
	}
	
	//1. 추가로 메소드 추가: public void abc(){}
}

//class가 여러개일 때 public은 한개만 있어야 된다.
class abc{
	
}
