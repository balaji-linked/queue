package my.sc.queue.client.receiver;

public class FileProcessorFactory {

	private FileProcessorFactory() {}
	
	public static FileProcessor createFileProcessor(String fileName) {
		
		if(fileName.endsWith("txt"))
			return new TxtFileProcessor();
		else if(fileName.endsWith("xml"))
			return new XMLFileProcessor();
		/**
		 * Add new file types here.
		 */
		
		throw new IllegalArgumentException("Invalid File type");
		
	}
	
	
}
