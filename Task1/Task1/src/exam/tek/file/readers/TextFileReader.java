package exam.tek.file.readers;

import java.io.BufferedReader;
import java.io.File;

public class TextFileReader implements FileReader{

	@Override
	public void readFile(File file) {
		try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
			String line = null;
			while (line != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
