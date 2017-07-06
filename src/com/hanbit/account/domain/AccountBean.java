package com.hanbit.account.domain;

public class AccountBean {
	String name, pw, id, regDate, ssn;
	int money, accountNum;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setPw(String pw){
		this.pw = pw;
	}
	public String getPw(){
		return pw;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public void setRegDate(String regDate){
		this.regDate = regDate;
	}
	public String getRegDate(){
		return regDate;
	}
	
	public void setSSN(String ssn){
		this.ssn = ssn;
	}
	public String getSSN(){
		return ssn;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return money;
	}
	
	public void setAccountNum(int accountNum){
		this.accountNum = accountNum;
	}
	public int getAccountNum(){
		return accountNum;
	}
	
	public String toString(){
		return "name: "+name+" pw: "+pw+" id: "+id+" ssn: "+ssn+" regDate: "+regDate+" accountNum: "+accountNum+" money: "+money+"\n";
	}
}
