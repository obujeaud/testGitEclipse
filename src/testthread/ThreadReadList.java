package testthread;

public class ThreadReadList extends Thread {

	MultiThread mlt;

	public ThreadReadList(MultiThread mltt) {
		mlt = mltt;
	}

	public void run() {
		System.out.println("Lancement du thread ThreadReadList");
		try {
			mlt.readThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
