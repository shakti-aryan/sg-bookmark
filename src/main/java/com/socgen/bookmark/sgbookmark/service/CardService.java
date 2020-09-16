package com.socgen.bookmark.sgbookmark.service;

import com.socgen.bookmark.sgbookmark.model.CardDetail;

public interface CardService {

	CardDetail createCard(CardDetail cardDetails);
	
	CardDetail fetchCardById(Integer id);
	
	CardDetail fetchCardByTinyUrl(String tinyUrl);
}
