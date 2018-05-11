package com.starwars.starwarsbatch.launcher;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SwapiJobLauncher {

    private JobLauncher jobLauncher;

    private Job job;

    @Scheduled(fixedDelay = 20000)
    public void run() throws JobParametersInvalidException,
                             JobExecutionAlreadyRunningException,
                             JobRestartException,
                             JobInstanceAlreadyCompleteException {

        JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}