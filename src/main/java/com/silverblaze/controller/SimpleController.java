package com.silverblaze.controller;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
		try {
			if (file.isEmpty()) {
				return "index";
			}
			
			storageService.store(file);
			File fileStoraged = storageService.loadAsResource(file.getOriginalFilename()).getFile();
			Map<String, Integer> map = simpleController.countWord(fileStoraged);
			model.addAttribute("map", map);
			return "words";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}

}
