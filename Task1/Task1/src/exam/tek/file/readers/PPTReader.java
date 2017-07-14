package exam.tek.file.readers;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class PPTReader implements FileReader {

	@Override
	public void readFile(File file) {
		XMLSlideShow ppt;
		try (FileInputStream inputStream = new FileInputStream(file);) {
			ppt = new XMLSlideShow(inputStream);
			CoreProperties props = ppt.getProperties().getCoreProperties();
			String title = props.getTitle();
			System.out.println("Title: " + title);
			for (XSLFSlide slide : ppt.getSlides()) {
				System.out.println("Starting slide...");
				XSLFShape[] shapes = slide.getShapes();
				for (XSLFShape shape : shapes) {
					if (shape instanceof XSLFTextShape) {
						XSLFTextShape textShape = (XSLFTextShape) shape;
						String text = textShape.getText();
						System.out.println("Text: " + text);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
