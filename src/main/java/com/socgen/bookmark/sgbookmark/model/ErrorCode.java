
package com.socgen.bookmark.sgbookmark.model;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ErrorCode {

	@JsonValue
	String getErrorCode();
	
	String toString();
}