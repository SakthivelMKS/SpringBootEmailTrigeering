package com.cgi.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import com.cgi.demo.domain.StageTable;

public class NotificationReaderListener implements ItemReadListener<StageTable> { 

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationReaderListener.class);


@Override
public void beforeRead() {
	// TODO Auto-generated method stub
	 LOGGER.info("beforeRead");
}

@Override
public void afterRead(StageTable item) {
	// TODO Auto-generated method stub
	 LOGGER.info("afterRead");
}

@Override
public void onReadError(Exception ex) {
	// TODO Auto-generated method stub
	 LOGGER.info("onReadError");
}

}