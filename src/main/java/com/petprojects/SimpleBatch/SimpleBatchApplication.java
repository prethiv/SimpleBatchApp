package com.petprojects.SimpleBatch;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobExecution;
import org.springframework.core.env.Environment;

@Configuration
@EnableBatchProcessing
@Import(DataSourceAutoConfiguration.class)
public class SimpleBatchApplication {

	public static void main(String[] args) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("batch-config.xml");
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(args[0],Job.class);
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Job Exit Status : " + execution.getStatus());
		context.close();


	}

}
