package my.sc.queue.fileserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import my.sc.queue.client.Message;



@RestController
@RequestMapping("/file")
public class FileUploadController {

	@RequestMapping(method = RequestMethod.POST)
	public Message uploadFile(String name, MultipartFile file) {
		return new Message();
	}
	
	@RequestMapping(path="/{fileId}", method=RequestMethod.DELETE)
	public void deleteFile(@PathVariable Integer fileId) {
		/**
		 * 1. Remove file from the file system
		 * 2. Delete entry from the local database.
		 */
	}
	
}
