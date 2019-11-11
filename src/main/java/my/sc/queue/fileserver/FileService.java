package my.sc.queue.fileserver;

import java.util.List;

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
	
	/**
	 * Adds new file type to the allowed list.
	 */
	public void addFileType(String fileType);
	
	/**
	 * Deletes a fileType from the already available list.
	 * @param fileType
	 */
	public void deleteFileType(String fileType);
	
	/**
	 * Returns the list of all allowed file types.
	 * @return
	 */
	public List<String> getAllType();
	
}
