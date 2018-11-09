package stat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestBuffered {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("file/alire"));

		try {
			while (true) {
				String l = br.readLine();
				if (l == null) {
					break;
				}
				System.out.println(l);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}