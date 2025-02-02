package com.i.manual.fileio.readtxt;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileIOReadtxtController {
	
	@GetMapping("/FileIO/Readtxt/Form")
	public String Form() {
	
		return "fileio/readtxt/Form";
	}
	
	@PostMapping("/FileIO/Basic/txtUpload")
	public String SingleUpload(@RequestParam("txtUpload") MultipartFile file) {
		
		try {
			byte[] fileBytes = file.getBytes();
			String fileContent = new String(fileBytes);
			System.out.println(fileContent);
		} catch (IOException e) {
            e.printStackTrace();
        }

		return "redirect:/FileIO/Readtxt/Form";
	}
}
