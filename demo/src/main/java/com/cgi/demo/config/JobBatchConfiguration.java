package com.cgi.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cgi.demo.domain.Audit;
import com.cgi.demo.domain.StageTable;
import com.cgi.demo.job.NotificationProcessor;
import com.cgi.demo.job.NotificationReader;
import com.cgi.demo.job.NotificationWriter;
import com.cgi.demo.listener.NotificationJobListener;
import com.cgi.demo.listener.NotificationProcessorListener;
import com.cgi.demo.listener.NotificationReaderListener;
import com.cgi.demo.listener.NotificationWriterListener;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	@StepScope
	public NotificationReader reader() {

		return new NotificationReader();
	}

	@Bean
	@StepScope
	public NotificationProcessor processor() {
		return new NotificationProcessor();
	}

	@Bean
	@StepScope
	public NotificationWriter writer() {
		return new NotificationWriter();
	}

	@Bean
	public NotificationJobListener jobExecutionListener() {
		return new NotificationJobListener();
	}

	@Bean
	public NotificationReaderListener readerListener() {
		return new NotificationReaderListener();
	}

	@Bean
	public NotificationProcessorListener notificationProcessorListener() {
		return new NotificationProcessorListener();
	}

	@Bean
	public NotificationWriterListener writerListener() {
		return new NotificationWriterListener();
	}

	@Bean
	public Job job(Step step, NotificationJobListener jobExecutionListener) {
		Job job = jobBuilderFactory.get("job2").listener(jobExecutionListener).incrementer(new RunIdIncrementer())
				.flow(step).end().build();
		return job;
	}

	@Bean
	public Step step(NotificationReader reader, NotificationWriter writer, NotificationProcessor processor,
			NotificationReaderListener readerListener, NotificationProcessorListener notificationProcessorListener,
			NotificationWriterListener writerListener) {

		TaskletStep step = stepBuilderFactory.get("step1").<StageTable, Audit>chunk(100).reader(reader)
				.processor(processor).writer(writer).listener(readerListener).listener(notificationProcessorListener)
				.listener(writerListener).build();
		return step;
	}

}
