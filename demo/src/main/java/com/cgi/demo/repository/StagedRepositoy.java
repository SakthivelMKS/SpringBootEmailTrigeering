package com.cgi.demo.repository;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgi.demo.domain.StageTable;

@Repository
public interface StagedRepositoy extends JpaRepository<StageTable, Long> {

	@Query("SELECT st FROM StageTable st WHERE st.status ='Faill' and st.updatedTimeStamp >= :fiveMinutesDealyTime and st.updatedTimeStamp <= :currentTime")
	List<StageTable> findByStatusFaill(@Param("currentTime") Timestamp currentTime,
			@Param("fiveMinutesDealyTime") Timestamp fiveMinutesDealyTime);

}
