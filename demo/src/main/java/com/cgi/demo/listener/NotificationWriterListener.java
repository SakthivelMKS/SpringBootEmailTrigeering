package com.cgi.demo.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import com.cgi.demo.domain.Audit;

public class NotificationWriterListener implements ItemWriteListener<Audit> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationWriterListener.class);



	@Override
	public void beforeWrite(List<? extends Audit> items) {
		// TODO Auto-generated method stub
    	LOGGER.info("beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Audit> items) {
		// TODO Auto-generated method stub
		LOGGER.info("afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Audit> items) {
		// TODO Auto-generated method stub
		LOGGER.info("onWriteError");
	}}
