package stat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader r = new FileReader("file/alire");
		FileWriter w = new FileWriter("file/newFile");

		try {
			String s = "";
			char[] bst = new char[1024];
			int leB = 0;

			while (leB != -1) {
				leB = r.read(bst);
				if (leB != -1) {
					s += new String(bst, 0, leB);
					w.write(bst, 0, leB);
					System.out.println(s);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
