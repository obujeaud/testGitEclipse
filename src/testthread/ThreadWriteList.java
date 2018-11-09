package testthread;

public class ThreadWriteList extends Thread {

	MultiThread mlt;

	public ThreadWriteList(MultiThread mltt) {
		mlt = mltt;
	}

	public void run() {
		System.out.println("Lancement du thread ThreadWriteList");
		try {
			mlt.writeTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
