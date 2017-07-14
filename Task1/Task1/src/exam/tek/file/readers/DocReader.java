package exam.tek.file.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocReader implements FileReader {

	@Override
	public void readFile(File file) {
		XWPFWordExtractor we = null;
		try (FileInputStream fis = new FileInputStream(file)) {
			XWPFDocument docx = new XWPFDocument(fis);
			we = new XWPFWordExtractor(docx);
			System.out.println(we.getText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (we != null) {
				try {
					we.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
