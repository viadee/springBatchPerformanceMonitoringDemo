package de.viadee.sbpm.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private JobRepository jobReporitory;

	@Autowired
	private Job job;

	@GetMapping("/launchjob")
	public String launchJob() {

		long start = System.currentTimeMillis();

		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			SimpleJobLauncher launcher = new SimpleJobLauncher();
			launcher.setJobRepository(jobReporitory);
			launcher.setTaskExecutor(new SyncTaskExecutor());
			launcher.run(job, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long completion = System.currentTimeMillis() - start;

		return "Time to completion: " + completion / 1000.0 + " seconds";
	}

}
