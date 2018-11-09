package stat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream f = new FileInputStream("file/alire");
		FileOutputStream o = new FileOutputStream("file/newFile");

		try {
			String s = "";
			byte[] bst = new byte[1024];
			int leB = 0;

			while (leB != -1) {
				leB = f.read(bst);
				if (leB != -1) {
					s += new String(bst, 0, leB);
				}
			}
			String lp = s.toUpperCase();
			o.write(lp.getBytes());
			System.out.println(lp);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				f.close();
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}