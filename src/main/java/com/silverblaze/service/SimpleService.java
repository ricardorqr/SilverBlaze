package com.silverblaze.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	public Map<String, Integer> countWord(File file) throws FileNotFoundException {
		Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().toLowerCase();
			String words[] = line.trim().split(" ");

			for (String word : words) {
				if (!wordCounts.containsKey(word.trim())) {
					wordCounts.put(word, 1);
				} else {
					wordCounts.put(word, wordCounts.get(word) + 1);
				}
			}
		}

		scanner.close();
		wordCounts = wordCounts.entrySet().stream().sorted(
				Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return wordCounts;
	}

}
