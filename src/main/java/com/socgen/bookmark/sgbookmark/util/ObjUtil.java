package com.socgen.bookmark.sgbookmark.util;

import java.util.Collection;

public class ObjUtil {
	
	public static boolean isBlank(String src){
		return src == null || src.trim().isEmpty();
	}
	
	public static boolean isNullOrEmpty(String src){
		return src==null || src.isEmpty();
	}
	
	public static boolean isNullOrEmpty(Collection obj){
		return obj==null || obj.isEmpty();
	}
}
