package my.sc.queue.fileserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMetaDataDAO fileMetaDataDAO;
	
	@Override
	public FileMetaData saveFile(MultipartFile file, String fileName) {
		//validate inputs here.
		/**
		 * 1. Save file to the disk.
		 * 2. Get the public url.
		 * 3. save data to database
		 */
		FileMetaData fileMetaData = null;
		return fileMetaDataDAO.saveFileMetaData(fileMetaData);
	}

	@Override
	public void deleteFile(Integer fileId) {
		//validate inputs here.
		fileMetaDataDAO.deleteFileMetaData(fileId);
	}
	
}
