package serverData;

public class UserData {
	int countOutOfDeathLine = 0;
	int countThumbler = 0;
	Thumbler[] thumbler = new Thumbler[50];
	
	void BuyThumbler() {
		thumbler[countThumbler] = new Thumbler();
		countThumbler ++;
	}
	
	boolean borrowThumbler(int i) {
		return thumbler[i].borrow();
	}
	
	void returnThumbler(int i) {
		if(thumbler[i].checkOutOfDeathLine()) countOutOfDeathLine++;
		thumbler[i].restorationComplete();
	}
	
	
}
