package exam.tek.client;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import exam.tek.file.readers.DocReader;
import exam.tek.file.readers.ExcelReader;
import exam.tek.file.readers.FileReader;
import exam.tek.file.readers.PPTReader;
import exam.tek.file.readers.TextFileReader;

public class ClientApp {

	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to the Repository Reader");
		showOptions();
		String command = scanner.nextLine();
		if(command == null || command.isEmpty() || command.split("\\s").length < 2) {
			System.out.println("Invalid command");
		}
		String[] commands = command.split("\\s");
		if (commands[0].equalsIgnoreCase("listp")) {
			FileReader fileReader = (File file)->{};
			List<String> files = fileReader.getProjects(commands[1]);
			files.forEach(System.out::println);
				
		}
		if (commands[0].equalsIgnoreCase("listf")) {
			FileReader fileReader = (File file)->{};
			List<String> files = fileReader.getFiles(commands[1]);
			files.forEach(System.out::println);
		}
		if (commands[0].equalsIgnoreCase("showf")) {
			String fileName = commands[1];
			File file = new File(fileName);
			if(file.exists()) {
					String fileNameStr = file.getName();
					String ext = fileNameStr.substring(fileNameStr.lastIndexOf(".") + 1, fileNameStr.length());
					switch (ext) {
					
						case "xlsx" : {
							new ExcelReader().readFile(file);
							break;
						}
						case "pptx" : {
							new PPTReader().readFile(file);
							break;
						}
						case "docx" : {
							new DocReader().readFile(file);
							break;
						}
						case "txt" : {
							new TextFileReader().readFile(file);
							break;
						}
						default : {
							System.out.println("File Reader Not found for this object");
							break;
						}
					}
			}
		}
		
	}
	
	public static void showOptions() {
		System.out.println("Please choose the options :");
		System.out.println("listp projectName- for Listing the projects");
		System.out.println("listf projectName- for Listing the files");
		System.out.println("showf fileName - for display the content of file");
	}
}
