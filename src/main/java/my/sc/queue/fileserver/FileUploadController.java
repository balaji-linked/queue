package my.sc.queue.fileserver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import my.sc.queue.client.Message;



@RestController
@RequestMapping("/file")
public class FileUploadController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping(method = RequestMethod.POST)
	public FileMetaData uploadFile(String name, MultipartFile file, HttpServletRequest request) {
		String auth = request.getHeader("Authorization");
		//Validate auth against database.
		return fileService.saveFile(file, name);
	}
	
	@RequestMapping(path="/{fileId}", method=RequestMethod.DELETE)
	public void deleteFile(@PathVariable Integer fileId) {
		/**
		 * 1. Remove file from the file system
		 * 2. Delete entry from the local database.
		 */
		fileService.deleteFile(fileId);
	}
	
	@RequestMapping(path="/type", method=RequestMethod.POST)
	public void addType(String type) {
		fileService.addFileType(type);
	}
	
	@RequestMapping(path="/type/{fileType}", method=RequestMethod.DELETE)
	public void deleteType(@PathVariable String fileType) {
		fileService.deleteFileType(fileType);
	}
	
	@RequestMapping(path="/type", method=RequestMethod.GET)
	public List<String> getAllFileTypes() {
		return fileService.getAllType();
	}
	
	
	
}
