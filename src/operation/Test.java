package operation;
import java.util.Scanner;

import serverData.*;
public class Test {
	
	public static void main(String args[]) {
		UserData[] ud = new UserData[10000];
		Scanner scanner = new Scanner(System.in);
		int userCount = 0;
		
		signLoop :while(true) {
			int sign = scanInteger();
			
			switch(sign){
			
			//회원가입
			case 0:
				String id = scanString();
				String pw = scanString();
				String cardNum= scanString();
				for(int i = 0; i<userCount; ++i) 
					if(ud[i].checkId(id)) {
						sendBoolean(false);
						continue signLoop;
					}
				
				ud[userCount++] = new UserData(id, pw, cardNum);
				sendBoolean(true);
				break;
			
			//로그인
			case 1:
				 String checkID = scanString();
				 String checkPw = scanString();
				 for(int i = 0; i<userCount; ++i) 
						if(ud[i].checkLogin(checkID, checkPw)) {
							sendBoolean(true);
							break;
						}
				 break;
			
				 
			//컵 구매
			case 2:
				String PurchaseId = scanString();
				int order = -1;
				for(int i = 0; i<userCount; ++i) 
					if(ud[i].checkId(PurchaseId)) {
						order = i;
						break;
					}
				if(order<0) {
					sendBoolean(false);
					break;
				}
				try {
					ud[order].purchaseTumbler();
					sendBoolean(true);
				} catch(Exception e) {
					sendBoolean(false);
				} 
				break;
			
			//컵 개수 확인
			case 3:	
				String owner = scanString();
				int orderNum = -1;
				for(int i = 0; i<userCount; ++i) 
					if(ud[i].checkId(owner)) {
						order = i;
						break;
					}
				if(orderNum<0) {
					sendBoolean(false);
					break;
				}
				sendString(Integer.toString(ud[orderNum].totalTumblerNum())+"/"
				+Integer.toString(ud[orderNum].totalTumblerNum()));
				sendBoolean(true);
				break;
			//컵 반납
			case 4:
				long TumblerCode = scanLong();
				for(int  i =0; i<userCount; ++i) {
					if(ud[i].hasThisTumblerCode(TumblerCode)) {
						ud[i].returnTumbler(TumblerCode);
					}
				}
				sendBoolean(true);
			
				
			
			
			default: 
				sendBoolean(false);
			}
		}
	}
	
	static String scanString() {
		Scanner scanner = new Scanner(System.in);
		return (scanner.nextLine());
	}
	
	static int scanInteger() {
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine());
	}
	
	static long scanLong() {
		Scanner scanner = new Scanner(System.in);
		return Long.parseLong(scanner.nextLine());
	}
	static void sendBoolean(boolean x) {
		System.out.println(x);
	}
	static void sendString(String x) {
		System.out.println(x);
	}
}
