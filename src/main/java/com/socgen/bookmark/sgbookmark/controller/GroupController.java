package com.socgen.bookmark.sgbookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.bookmark.sgbookmark.exception.ExceptionMapper;
import com.socgen.bookmark.sgbookmark.model.ApiResponse;
import com.socgen.bookmark.sgbookmark.model.GroupReq;
import com.socgen.bookmark.sgbookmark.service.GroupService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/group")
public class GroupController extends ExceptionMapper{
	
	@Autowired
	private GroupService grpService;
	
	@PostMapping("/create")
	@ResponseBody
	public ApiResponse createGroup(@RequestBody GroupReq payload) {
		
		ApiResponse response = new ApiResponse();
		response.add("group", grpService.createGroup(payload));
		response.setOk(true);
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ApiResponse fetchById(@PathVariable Integer id) {
		
		ApiResponse response = new ApiResponse();
		response.add("group", grpService.fetchGroupById(id));
		response.setOk(true);
		return response;
	}
	
	@GetMapping("/url")
	@ResponseBody
	public ApiResponse fetchByTinyUrl(@RequestParam(required=true, value="shortUrl") String shortUrl) {
		
		ApiResponse response = new ApiResponse();
		response.add("group", grpService.fetchGroupByUrl(shortUrl));
		response.setOk(true);
		return response;
	}
}
