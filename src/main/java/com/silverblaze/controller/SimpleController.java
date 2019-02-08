package com.silverblaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.silverblaze.service.SimpleService;
import com.silverblaze.service.storage.StorageService;

@Controller
public class SimpleController {

	@Autowired
	private SimpleService simpleController;

	@Autowired
	private StorageService storageService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {
		try {
			storageService.store(file);
			simpleController.countWord(storageService.loadAsResource(file.getOriginalFilename()).getFile());
			System.out.println(file);
			return "words";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
