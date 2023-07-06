package com.cgi.demo.job;

import java.sql.Timestamp;

import org.springframework.batch.item.ItemProcessor;

import com.cgi.demo.domain.Audit;
import com.cgi.demo.domain.StageTable;




public class NotificationProcessor implements ItemProcessor<StageTable, Audit>  {

	@Override
	public Audit process(StageTable emp) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+emp);
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		Audit audit = new Audit();
		audit.setStageId(emp.getId());
		audit.setExpressionName(emp.getExpressionName());
		audit.setStatus(emp.getStatus());
		audit.setReason(emp.getReason());
		audit.setCreatedTimeStamp(timestamp);
		audit.setUpdatedTimeStamp(timestamp);
		return audit;
	}
}
