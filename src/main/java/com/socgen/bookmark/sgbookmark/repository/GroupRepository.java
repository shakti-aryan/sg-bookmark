package com.socgen.bookmark.sgbookmark.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socgen.bookmark.sgbookmark.entity.Group;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Group, Integer> {

	@Query(value = "SELECT * from tinyurl.group_details where group_url=:tinyUrl", nativeQuery = true)
	Group fetchGroupByTinyUrl(@Param("tinyUrl") String tinyUrl);
}
