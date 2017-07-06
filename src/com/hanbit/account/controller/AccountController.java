package com.hanbit.account.controller;

import java.util.Vector;

import javax.swing.JOptionPane;
import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;
import com.hanbit.account.serviceImpl.AccountServiceImpl;


public class AccountController {
	public static void main(String[] args){
		
		AccountBean bean = null;
		AccountService service = new AccountServiceImpl();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료  1.계좌개설  2.계좌전체목록  3.이름검색  4.계좌번호조회  5.전체계좌수  6.비밀번호 변경  7.예금  8.출금  9.계좌해지")){
			case"0": 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case"1": 
				bean = new AccountBean();
				String arr[] = JOptionPane.showInputDialog("이름/비번/아이디/입금액/SSN").split("/");
	            bean.setName(arr[0]);
	            bean.setPw(arr[1]);
	            bean.setId(arr[2]);
	            bean.setMoney(Integer.parseInt(arr[3]));
	            bean.setSSN(arr[4]);
	            service.addAccount(bean);
	            JOptionPane.showMessageDialog(null, "계좌 개설 성공!");
				break;
			case"2": 
				Vector<AccountBean> vec = service.accountList();
	            JOptionPane.showMessageDialog(null, vec+"\n");
				break;
			case"3": 
				Vector<AccountBean> vec2 = service.findByName(JOptionPane.showInputDialog("이름을 입력하세요"));
	            JOptionPane.showMessageDialog(null, vec2);
				break;
			case"4": 
				bean = service.findByAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
	            JOptionPane.showMessageDialog(null, "");
				break;
			case"5":
				int count = service.countAccount();
				JOptionPane.showMessageDialog(null, "계좌수: "+count);
				break;
			case"6": 
				String[] foo = JOptionPane.showInputDialog("계좌번호/비번").split("/");
				bean.setAccountNum(Integer.parseInt(foo[0]));
				bean.setPw(foo[1]);
				service.updatePW(bean);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case"7": 
				String[] foo2 = JOptionPane.showInputDialog("계좌번호/예금금액").split("/");
				bean.setAccountNum(Integer.parseInt(foo2[0]));
				bean.setMoney(Integer.parseInt(foo2[0]));
				service.updateDeposit(bean);
				JOptionPane.showMessageDialog(null, "예금완료");
				break;
			case"8": 
				String[] foo3 = JOptionPane.showInputDialog("계좌번호/출금금액").split("/");
				bean.setAccountNum(Integer.parseInt(foo3[0]));
				bean.setMoney(Integer.parseInt(foo3[0]));
				service.updateDeposit(bean);
				JOptionPane.showMessageDialog(null, "예금완료");
				break;
			case"9": 
				service.deleteAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
	            JOptionPane.showMessageDialog(null, "계좌 해지 완료");
				break;
			}
		}
	}
}
