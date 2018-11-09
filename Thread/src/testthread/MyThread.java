package testthread;

import java.util.Scanner;

public class MyThread extends Thread {
	Scanner sc;
	MultiThread mlt = new MultiThread();

	public MyThread(MultiThread mltt) {
		mlt = mltt;
	}

	public void run() {
		System.out.println("Run du thread " + getClass().getName());
		try {
			mlt.message();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void timerMsg(int t) throws InterruptedException {
		sc = new Scanner(System.in);
		System.out.println("Veuillez écrire une phrase");
		String laPhrase = sc.nextLine();

		for (int i = 1; i <= t; i++) {
			sleep(1000);
			System.out.println(i + " : " + laPhrase);
		}
	}
}