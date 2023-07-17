import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileSearch {
	public static void main(String[] args) throws IOException {
		fileSearch("C:\\dev\\");
	}

	public static void fileSearch(String path) throws IOException {
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		FileWriter writer = new FileWriter(new File("C:\\dev\\fileList_swing.txt"), true);
		
		for (int i=0; i<fileList.length; i++) {
			File file = fileList[i];

			if (file.isFile()) {
				if (!file.getName().equals(".DS_Store")) {
					System.out.println("파일 : " + file.getAbsolutePath());
					writer.write(file.getAbsolutePath() + "\n");
					writer.flush();
				}
			} else if (file.isDirectory()) {
				fileSearch(file.getAbsolutePath().toString());
			}
		}
	}
}
