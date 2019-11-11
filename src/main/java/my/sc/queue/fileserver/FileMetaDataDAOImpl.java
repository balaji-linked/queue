package my.sc.queue.fileserver;

import org.springframework.stereotype.Repository;

@Repository
public class FileMetaDataDAOImpl implements FileMetaDataDAO {

	@Override
	public FileMetaData saveFileMetaData(FileMetaData fileMetaData) {
		/**
		 * Save file meta data to DB and return the meta data filled with id.
		 */
		return null;
	}

	@Override
	public void deleteFileMetaData(Integer id) {
		/**
		 * Delete the given meta data with the given id.
		 */
	}

	
	
}
