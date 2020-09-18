package com.socgen.bookmark.sgbookmark.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.bookmark.sgbookmark.entity.Card;
import com.socgen.bookmark.sgbookmark.entity.Group;
import com.socgen.bookmark.sgbookmark.model.CardDetail;
import com.socgen.bookmark.sgbookmark.model.GroupDetail;
import com.socgen.bookmark.sgbookmark.model.GroupReq;
import com.socgen.bookmark.sgbookmark.repository.CardRepository;
import com.socgen.bookmark.sgbookmark.repository.GroupRepository;
import com.socgen.bookmark.sgbookmark.service.GroupService;
import com.socgen.bookmark.sgbookmark.service.UrlService;
import com.socgen.bookmark.sgbookmark.util.DateUtil;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private CardRepository cardRepo;
	
	@Autowired 
	private UrlService urlService;
	
	@Autowired
	private GroupRepository grpRepo;

	@Override
	public GroupDetail createGroup(GroupReq groupReq) {

		List<Card> cardList = cardRepo.findAllById(groupReq.getCardIdList());
		
		if(cardList.contains(null))
			throw new EntityNotFoundException("Entity Doesn't exist with provided id");
		
		String shortUrl = urlService.getGroupShortenUrl();

		Group group = new Group();
		group.setDescription(groupReq.getDescription());
		group.setName(groupReq.getName());
		group.setGroupUrl(shortUrl);
		group.setCreatedDate(DateUtil.convertDateToTimestamp(new Date()));
		group.setCreatedBy(111);
		group  = grpRepo.save(group);
		
		cardList = sanitizeCardList(cardList, group.getId());
		
		cardList = cardRepo.saveAll(cardList);
		
		return convertEntityToPojo(group);
	}

	@Override
	public GroupDetail fetchGroupById(Integer id) {
		
		Group group = grpRepo.getOne(id);
		
		if(group == null) {
			throw new EntityNotFoundException();
		}
		return convertEntityToPojo(group);
	}

	@Override
	public GroupDetail fetchGroupByUrl(String url) {
		
		Group group = grpRepo.fetchGroupByTinyUrl(url);
		
		if(group == null) {
			throw new EntityNotFoundException();
		}
		
		return convertEntityToPojo(group);
	}
	
	private GroupDetail convertEntityToPojo(Group group) {
		
		GroupDetail detail = new GroupDetail();
		
		List<Card> associatedCardList = cardRepo.getGroupAssociatedCard(group.getId());
		detail.setAssociatedCards(convertCardDetailPojo(associatedCardList));
		detail.setName(group.getName());
		detail.setId(group.getId());
		detail.setDescription(group.getDescription());
		detail.setGroup_url(group.getGroupUrl());
		return detail;
	}
	
	private List<CardDetail> convertCardDetailPojo(List<Card> cardList){
		
		List<CardDetail> cardPojoList = new ArrayList<>();
		
		cardList.forEach(card ->{
			CardDetail details = new CardDetail();
			details.setCreatedAt(DateUtil.convertTimestampToDate(card.getCreatedDate()));
			details.setDescription(card.getDescription());
			details.setCreatedBy(card.getCreatedBy());
			details.setId(card.getId());
			details.setOriginalUrl(card.getLongUrl());
			details.setShortUrl(card.getTinyUrl());
			details.setTitle(card.getTitle());
			cardPojoList.add(details);
		});
		return cardPojoList;
	}
	
	private List<Card> sanitizeCardList(List<Card> cardList, Integer grpId){
		
		List<Card> updatedCardList = new ArrayList<>();
		
		cardList.forEach(cardInfo ->{
			Card card = new Card();
			card.setExpiryDate(null);
			card.setId(null);
			card.setGroupId(grpId);
			card.setDescription(cardInfo.getDescription());
			card.setTitle(cardInfo.getTitle());
			card.setLongUrl(cardInfo.getLongUrl());
			card.setTinyUrl(cardInfo.getTinyUrl());
			card.setCreatedDate(DateUtil.convertDateToTimestamp(new Date()));
			
			updatedCardList.add(card);
		});
		return updatedCardList;
	}

}
