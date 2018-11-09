package testthread;

import java.util.ArrayList;
import java.util.List;

public class MultiThread {

	private boolean isContinue = true;
	private boolean isZero = false;
	private MyThread mt;
	private ThreadWriteList twl;
	private ThreadReadList trl;
	private List<String> listThread = new ArrayList<>();

	public void alphaMain() throws InterruptedException {
		mt = new MyThread(this);
		mt.start();
		while (isContinue) {
			System.out.println("Fonction main");
			Thread.sleep(1000);
		}
		System.out.println("Fin fonction main du MultiThread");
	}

	public void message() throws InterruptedException {
		System.out.println("Message de la méthode message");
		Thread.sleep(10000);
		isContinue = false;
		System.out.println("Fin du flag");
	}

	public void main() throws InterruptedException {
		twl = new ThreadWriteList(this);
		trl = new ThreadReadList(this);
		twl.start();
		trl.start();
	}

	public void writeTest() throws InterruptedException {
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < a.length(); i++) {
			String value = (a.charAt(i)) + "" + (a.charAt(i)) + "" + (a.charAt(i));
			listThread.add(value);
			Thread.sleep(1);
		}
	}

	public void readThread() throws InterruptedException {
		while (!isZero) {
			if (listThread.size() != 0) {
				String a = listThread.get(0);
				System.out.println(a);
				listThread.remove(0);
				if (a.equals("ZZZ")) {
					System.out.println("Fin de la liste");
					isZero = true;
				}
			}
			Thread.sleep(1000);
		}
	}
}