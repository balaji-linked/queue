package my.sc.queue.fileserver;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public FileMetaData saveFile(MultipartFile file, String fileName) {
		//validate inputs here.
		/**
		 * 1. Save file to the disk.
		 * 2. Get the public url.
		 * 3. save data to database.
		 */
		FileMetaData fileMetaData = null;
		return fileMetaData;
	}

	@Override
	public void deleteFile(Integer fileId) {
		//validate inputs here.
		//Delete the file from fileSystem.
		
	}
	
	private void validateFileType(String fileName) {
		/**
		 * 1. Pull allowed file types from either cache or from database.
		 * 2. Check whether the file is of allowed type.
		 * 3. If its not of allowed type throw an exception.
		 * 4. Otherwise, just proceed further. 
		 */
	}

	@Override
	public void addFileType(String fileType) {
		/**
		 * Add a new file type to the allowed list
		 */
		
	}

	@Override
	public void deleteFileType(String fileType) {
		/**
		 * delete the given type from the allowed list.
		 */
		
	}

	@Override
	public List<String> getAllType() {
		/**
		 *  Get all currently allowed types.
		 */
		return null;
	}
	
	
	
}
