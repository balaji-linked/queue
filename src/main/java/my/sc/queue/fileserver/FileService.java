package my.sc.queue.fileserver;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	/**
	 * Validates the file type. if not supported, then throws a runtime exception with proper message.
	 * Otherwise saves the file to the disk, populates meta data and returns it.
	 * 
	 * @param file
	 * @param fileName
	 * @return
	 */
	public FileMetaData saveFile(MultipartFile file, String fileName);
	
	
	/**
	 * Delete a file meta data from the database.
	 * @param fileId
	 */
	public void deleteFile(Integer fileId);
	
}
