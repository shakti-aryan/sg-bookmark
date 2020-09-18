package com.socgen.bookmark.sgbookmark.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socgen.bookmark.sgbookmark.entity.Card;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card, Integer> {
	
	@Query(value = "SELECT * from tinyurl.card_details where tiny_url=:tinyUrl", nativeQuery = true)
	Card fetchCardByTinyUrl(@Param("tinyUrl") String tinyUrl);
	
	@Query(value = "SELECT long_url from tinyurl.card_details where tiny_url=:tinyUrl", nativeQuery = true)
	String getOriginalUrlByTinyUrl(@Param("tinyUrl") String tinyUrl);
	
	@Query(value = "SELECT * from tinyurl.card_details where id IN :idList", nativeQuery = true)
	List<Card> getCardListByIdList(@Param("idList") List<Integer> idList);
	
	@Query(value = "SELECT * from tinyurl.card_details where associated_group=:groupId", nativeQuery = true)
	List<Card> getGroupAssociatedCard(@Param("groupId") Integer groupId);
}
