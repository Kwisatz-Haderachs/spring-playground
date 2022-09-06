package com.galvanize.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	static String clean(String identifier) {
		char[] cl = identifier.replace(" ", "_").replace("-", "").toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c :cl) {
			if(c == '\0'){
				sb.append("CTRL");
			} else if (Character.isAlphabetic(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}