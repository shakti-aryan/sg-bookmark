package com.socgen.bookmark.sgbookmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SgBookmarkApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SgBookmarkApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SgBookmarkApplication.class, args);
	}

}
