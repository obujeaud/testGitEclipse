package testthread;

public class SecondTimer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread t = new MyThread(null);
		t.start();
		//t.timerMsg(12);
	}

}
