package com.socgen.bookmark.sgbookmark.service.impl;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.bookmark.sgbookmark.constant.AppConstant;
import com.socgen.bookmark.sgbookmark.entity.Card;
import com.socgen.bookmark.sgbookmark.model.CardDetail;
import com.socgen.bookmark.sgbookmark.model.CardReq;
import com.socgen.bookmark.sgbookmark.repository.CardRepository;
import com.socgen.bookmark.sgbookmark.service.CardService;
import com.socgen.bookmark.sgbookmark.service.UrlService;
import com.socgen.bookmark.sgbookmark.util.DateUtil;
import com.socgen.bookmark.sgbookmark.util.ObjUtil;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepo;
	
	@Autowired UrlService urlService;
	
	@Override
	public CardDetail createCard(CardReq cardDetails) {
		
		String shortenUrl = urlService.convertToShortUrl(cardDetails.getOriginalUrl());
		Date expiryDate = cardDetails.getExpiresAt() == null ? DateUtil.addDays(new Date(), 2) : cardDetails.getExpiresAt();
		
		Card card = new Card();
		card.setDescription(cardDetails.getDescription());
		card.setTitle(cardDetails.getTitle());
		card.setExpiryDate(DateUtil.convertDateToTimestamp(expiryDate));
		card.setLongUrl(cardDetails.getOriginalUrl());
		card.setTinyUrl(shortenUrl);
		card.setCreatedDate(DateUtil.convertDateToTimestamp(new Date()));
		
		card = cardRepo.save(card);
		
		return convertCardEntityToPojo(card);
	}

	@Override
	public CardDetail fetchCardById(Integer id) {
		
		Card card = cardRepo.getOne(id);
		
		if(card == null) {
			throw new EntityNotFoundException("There is no entity with " + id);
		}
		
		return convertCardEntityToPojo(card);
	}

	@Override
	public CardDetail fetchCardByTinyUrl(String tinyUrl) {

		Card card = cardRepo.fetchCardByTinyUrl(tinyUrl);
		
		if(card == null) {
			throw new EntityNotFoundException("There is no entity with " + tinyUrl);
		}
		
		return convertCardEntityToPojo(card);
	}
	
	@Override
	public String fetchOrignialUrl(String tinyUrl) {
		
		tinyUrl = UrlServiceImpl.sanitizeURL(tinyUrl);
		
		if(!tinyUrl.contains(AppConstant.domain))
			tinyUrl = new StringBuilder(AppConstant.redirectDomain).append(tinyUrl).toString();
		
		String originalUrl = cardRepo.getOriginalUrlByTinyUrl(tinyUrl);
		
		if(ObjUtil.isBlank(originalUrl))
			throw new EntityNotFoundException("There is no entity with " + tinyUrl);
		
		return originalUrl;
	}
	
	private CardDetail convertCardEntityToPojo(Card card) {
		
		CardDetail details = new CardDetail();
		Date expiryDate = DateUtil.convertTimestampToDate(card.getExpiryDate());
		
		details.setCreatedAt(DateUtil.convertTimestampToDate(card.getCreatedDate()));
		details.setDescription(card.getDescription());
		details.setCreatedBy(card.getCreatedBy());
		details.setExpiresAt(expiryDate);
		details.setId(card.getId());
		details.setOriginalUrl(card.getLongUrl());
		details.setShortUrl(card.getTinyUrl());
		details.setTitle(card.getTitle());
		
		if (expiryDate != null && expiryDate.before(new Date())){
            cardRepo.delete(card);;
            throw new EntityNotFoundException("Link expired!");
        }
		
		return details;
	}

}
