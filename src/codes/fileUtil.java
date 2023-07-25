package codes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.filesVO;

public class fileUtil {
	private List<filesVO> fList = new ArrayList<filesVO>();
	
	public List<filesVO> fileSearch(String path) {
        File dir = new File(path);
        File[] fileList = dir.listFiles();
        int lastIndex;
        String filename, foldername, formattedDate; 
        long fileSize;
        SimpleDateFormat dateFormat;
        
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
            	File file = fileList[i];
                if (file.isFile()) {
                    if (!file.getName().equals(".DS_Store")) {
                    	lastIndex = file.getAbsolutePath().lastIndexOf("\\");
                        filename = file.getAbsolutePath().substring(lastIndex + 1);
                        foldername = file.getAbsolutePath().substring(0, lastIndex);
                        fileSize = file.length();
                        
                        Date fileDate = new Date(file.lastModified());
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        formattedDate = dateFormat.format(fileDate);
                        
                        fList.add(new filesVO(filename, foldername, fileSize, formattedDate));
                    }
                } else if (file.isDirectory()) {
                    fileSearch(file.getAbsolutePath().toString());
                }
            }
        }
		return fList;
    }
}
