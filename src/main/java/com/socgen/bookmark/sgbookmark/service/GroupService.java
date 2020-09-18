package com.socgen.bookmark.sgbookmark.service;

import com.socgen.bookmark.sgbookmark.model.GroupDetail;
import com.socgen.bookmark.sgbookmark.model.GroupReq;

public interface GroupService {

	GroupDetail createGroup(GroupReq groupReq);
	
	GroupDetail fetchGroupById(Integer id);
	
	GroupDetail fetchGroupByUrl(String url);
}
