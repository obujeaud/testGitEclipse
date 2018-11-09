package testthread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t = new MyThread(null);
		t.start();
		System.out.println("Test");
	}
}