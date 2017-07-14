package exam.tek.file.readers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface FileReader {

	public static File getFile(String file) {
		return new File(file);
	}

	public default boolean isDirectory(File file) {
		if (file != null && file.exists() && file.isDirectory()) {
			return true;
		}
		return false;
	}

	public default List<String> getFiles(String dirName) {
		File file = getFile(dirName);
		if (file != null && isDirectory(file)) {
			File[] files = file.listFiles();
			List<String> fileList = new ArrayList<>();
			for (File f : files) {
				if (f != null && f.exists() && f.isFile())
					fileList.add(f.getName());
			}
			return fileList;
		}
		System.out.println("No files found");
		return null;
	}

	public default List<String> getProjects(String dirName) {
		File file = getFile(dirName);
		if (file != null && isDirectory(file)) {
			File[] files = file.listFiles();
			List<String> fileList = new ArrayList<>();
			for (File f : files) {
				if (f != null && f.exists() && f.isDirectory())
					fileList.add(f.getName());
			}
			return fileList;
		}
		System.out.println("No files found");
		return null;
	}

	public void readFile(File file);
}