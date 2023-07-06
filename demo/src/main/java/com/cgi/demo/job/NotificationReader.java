package com.cgi.demo.job;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import com.cgi.demo.domain.StageTable;
import com.cgi.demo.repository.StagedRepositoy;

public class NotificationReader implements ItemReader<StageTable> {

	@Autowired(required = true)
	private StagedRepositoy stagedRepositoy;

	private Iterator<StageTable> usersIterator;
	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	Instant instant = Instant.now().minus(5, ChronoUnit.MINUTES);
	Timestamp fiveMinutesDealyTime = Timestamp.from(instant);

	@BeforeStep
	public void before(StepExecution stepExecution) {

		usersIterator = stagedRepositoy.findByStatusFaill(currentTime, fiveMinutesDealyTime).iterator();

	}

	@Override
	public StageTable read() {
		if (usersIterator != null && usersIterator.hasNext()) {
			return usersIterator.next();
		} else {
			return null;
		}
	}
}
