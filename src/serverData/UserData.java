package serverData;

import java.util.*;

public class UserData {

	String id, pw, cardNum;
	public UserData(String id, String pw, String cardNum){
		this.id = id;
		this.pw = pw;
		this.cardNum = cardNum;
	}
	//아이디 확인
	public boolean checkId(String id) {
		if(id.equals(this.id)) return true;
		return false;
	}
	
	//로그인 확인
	public boolean checkLogin(String id, String pw) {
		if(this.id.equals(id)&&this.pw.equals(pw)) return true;
		return false;
	}
	
	Queue<Tumbler> restTumbler  = new LinkedList<>(); 
	Queue<Tumbler> borrowedTumbler = new LinkedList<>();
	
	//텀블러 구매
	public boolean purchaseTumbler() {
		try {
			Tumbler t = null;
			restTumbler.add(t);
			return true;
			
		} catch(Exception e){
			return false;
		}
	}
	
	//텀블러 고유 식별번호를 입력하여 빌림
	public boolean borrowTumbler(long tumblerCode) {
		try {
			restTumbler.poll();
			Tumbler t = new Tumbler(tumblerCode);
			borrowedTumbler.add(t);
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	
	//빌릴 수 있는 컵 개수
	public int restTumblerNum() {
		return restTumbler.size();
	}
	
	// 총 컵 개수
	public int totalTumblerNum() {
		return restTumbler.size()+borrowedTumbler.size();
	}
	
	//해당 텀블러 코드를 갖고 있는지 확인하는 함수
	public boolean hasThisTumblerCode(long TumblerCode) {
		try {
			for(int i = 0; i<borrowedTumbler.size(); ++i) {
				Tumbler bt = borrowedTumbler.poll();
				borrowedTumbler.add(bt);
				if(bt.getTumblerCode() == TumblerCode) return true;
		}
		return false;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean returnTumbler(long TumblerCode) {
		try {
			int order = -1;
			for(int i = 0; i<borrowedTumbler.size(); ++i) {
				Tumbler bt = borrowedTumbler.poll();
				if(bt.getTumblerCode() == TumblerCode) {
					order = i;
					break;
				}
				borrowedTumbler.add(bt);
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	
	
	
}
