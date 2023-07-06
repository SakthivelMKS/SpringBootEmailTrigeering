package com.cgi.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class NotificationJobListener implements JobExecutionListener{
    
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationJobListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
        LOGGER.info("beforeJob");

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
        LOGGER.info("afterJob");

	}

}
