package com.socgen.bookmark.sgbookmark.service;

import com.socgen.bookmark.sgbookmark.model.CardDetail;
import com.socgen.bookmark.sgbookmark.model.CardReq;

public interface CardService {

	CardDetail createCard(CardReq cardDetails);
	
	CardDetail fetchCardById(Integer id);
	
	CardDetail fetchCardByTinyUrl(String tinyUrl);
}
