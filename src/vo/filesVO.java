package vo;

public class filesVO {
	private String fileName;
	private String filePath;
	private long fileSize;
	private String fileDate;

	public filesVO(String fileName, String filePath, long fileSize, String fileDate){
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileDate = fileDate;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public String getFileDate() {
		return fileDate;
	}
}
