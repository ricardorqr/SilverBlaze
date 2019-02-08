package com.silverblaze.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	public Map<String, Integer> countWord(File file) throws FileNotFoundException {
		Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().toLowerCase();
			String words[] = line.split(" ");

			for (String word : words) {
				if (!wordCounts.containsKey(word)) {
					wordCounts.put(word, 1);
				} else {
					wordCounts.put(word, wordCounts.get(word) + 1);
				}
			}
		}

		scanner.close();
		return wordCounts;
	}

}
