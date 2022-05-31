package serverData;
import java.util.*;
class Thumbler {
	DateData dd = new DateData();
	//빌린 날짜와 반납 예정일
	Calendar borrowDate = null;
	Calendar deathLine = null;
	
	
	//빌리는 중이면 true 반납 완료 false;
	boolean checkState() {
		if(deathLine == null) return false;
		return true;
	}
	
	//컵 빌리기
	boolean borrow() {
		if(borrowDate == null) {
		borrowDate = dd.getDate();
		 deathLine = dd.addTime(0, 0, 7);
		return true;
		}
		return false;
	}
	
	//반납 완료 신호
	void restorationComplete() {
		borrowDate = null;
		deathLine = null;
	}
	
	//마감일이 지났는지 확인하는 함수
	boolean checkOutOfDeathLine() {
		if(deathLine == null) return false;
		if (dd.getDate().compareTo(deathLine)>0) return true;
		return false;
	}
	
}
