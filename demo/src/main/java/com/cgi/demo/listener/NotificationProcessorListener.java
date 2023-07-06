package com.cgi.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

import com.cgi.demo.domain.Audit;
import com.cgi.demo.domain.StageTable;

public class NotificationProcessorListener implements ItemProcessListener<StageTable, Audit> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProcessorListener.class);

	@Override
	public void beforeProcess(StageTable item) {
		// TODO Auto-generated method stub
		  LOGGER.info("beforeProcess");
	}

	@Override
	public void afterProcess(StageTable item, Audit result) {
		// TODO Auto-generated method stub
		  LOGGER.info("afterProcess");
	}

	@Override
	public void onProcessError(StageTable item, Exception e) {
		// TODO Auto-generated method stub
		  LOGGER.info("onProcessError");
	}

}
