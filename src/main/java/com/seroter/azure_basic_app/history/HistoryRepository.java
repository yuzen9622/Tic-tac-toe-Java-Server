package com.seroter.azure_basic_app.history;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

	@Query("SELECT h FROM History h WHERE h.member1=?1OR h.member2=?1")
	List<History> findByMembers(Long memberId);

}
