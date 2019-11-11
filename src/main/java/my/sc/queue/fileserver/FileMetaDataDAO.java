package my.sc.queue.fileserver;

public interface FileMetaDataDAO {

	/**
	 * Saves file meta data to DB and returns the meta data with id.
	 * @param fileMetaData
	 * @return
	 */
	public FileMetaData saveFileMetaData(FileMetaData fileMetaData);
	
	/**
	 * Deletes file meta data with the given id.
	 * @param id
	 */
	public void deleteFileMetaData(Integer id);
	
}
