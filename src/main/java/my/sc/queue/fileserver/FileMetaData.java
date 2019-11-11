package my.sc.queue.fileserver;

public class FileMetaData {

	private Integer fileId;
	
	private String publicUrl;

	public FileMetaData(Integer fileId, String publicUrl) {
		this.fileId = fileId;
		this.publicUrl = publicUrl;
	}
	
	public Integer getFileId() {
		return fileId;
	}

	public String getPublicUrl() {
		return publicUrl;
	}
	
	
	
}
