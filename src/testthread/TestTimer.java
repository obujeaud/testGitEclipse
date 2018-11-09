package testthread;

import java.util.Timer;

public class TestTimer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyThread t = new MyThread(null);
		t.start();
		Timer ti = new Timer();
		ti.schedule(MyTimerTask.makeTimer(), 1000, 1000);
	}
}