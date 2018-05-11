package com.starwars.starwarsbatch.config;

import com.starwars.starwarsbatch.tasklet.HellowWorldTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Step helloworldStep(StepBuilderFactory stepBuilderFactory, HellowWorldTasklet hellowWorldTasklet){
        return stepBuilderFactory
                .get("hellowWorldStep")
                .tasklet(hellowWorldTasklet)
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, Step helloworldStep){
        return jobBuilderFactory
                .get("job")
                .incrementer(new RunIdIncrementer())
                .start(helloworldStep)
                .build();
    }
}
