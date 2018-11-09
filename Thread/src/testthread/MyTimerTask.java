package testthread;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask {
	static TimerTask makeTimer() {
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(new Date());
			}
		};
		return tt;
	}
}