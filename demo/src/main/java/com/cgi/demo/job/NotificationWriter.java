package com.cgi.demo.job;



import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.demo.domain.Audit;
import com.cgi.demo.maill.CgiEmailService;
import com.cgi.demo.repository.AuditRepository;




public class NotificationWriter implements ItemWriter<Audit> {

	@Autowired(required = true)
	AuditRepository auditRepository ;
	
	@Autowired  
	CgiEmailService cgiEmailService;

	@Override
	public void write(List<? extends Audit> audits) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NotificationWriter : Processing data size: "+audits.size());
		cgiEmailService.sendMail(audits);
		auditRepository.saveAll(audits);
		/*
		 * for (Audit data : items) {
		 * //System.out.println("MyCustomWriter    : Writing data    : " +
		 * data.getId()+" : "+data.getName()+" : "+data.getSalary());
		 * auditRepository.save(data); }
		 */
	}

	

}
