package com.i.manual.fileio.readtxt;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileIOReadtxtController {
	
	@GetMapping("/file-io/read-txt/form")
	public String form() {
	
		return "fileio/readtxt/form";
	}
	
	@PostMapping("/file-io/basic/txt-upload")
	public String singleUpload(@RequestParam("txtUpload") MultipartFile file) {
		
		try {
			byte[] fileBytes = file.getBytes();
			String fileContent = new String(fileBytes);
			System.out.println(fileContent);
		} catch (IOException e) {
            e.printStackTrace();
        }

		return "redirect:/file-io/read-txt/form";
	}
}
