package com.starwars.starwarsbatch.config;

import com.starwars.starwarsbatch.listener.PeopleListener;
import com.starwars.starwarsbatch.model.people;
import com.starwars.starwarsbatch.processor.GenderProc;
import com.starwars.starwarsbatch.repository.PeopleRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableBatchProcessing
@EnableScheduling
public class Csv2XmlBatchConfiguration {
    @Bean
    public org.springframework.batch.item.ItemReader<people> peopleItemReader() {
        FlatFileItemReader<people> itemReader = new FlatFileItemReader<>();

        itemReader.setResource(new FileSystemResource("src/main/resources/people.csv"));

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("name","birthYear","gender","height","mass","eyeColor","hairColor","skinColor");

        BeanWrapperFieldSetMapper<people> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(people.class);

        DefaultLineMapper<people> lineMapper = new DefaultLineMapper<>();
        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.setLineTokenizer(lineTokenizer);
        itemReader.setLineMapper(lineMapper);

        return itemReader;
    }

    @Bean
    public ItemProcessor processor() {
        return new GenderProc();
    }

    @Bean
    public ItemWriter<people> getPeopleWriter(PeopleRepository peopleRepository){
        RepositoryItemWriter<people> itemWriter = new RepositoryItemWriter<>();

        itemWriter.setRepository(peopleRepository);
        itemWriter.setMethodName("save");

        return itemWriter;
    }

    @Bean
    public ItemWriter<people> peopleItemWriter() {
        StaxEventItemWriter<people> itemWriter = new StaxEventItemWriter<>();

        itemWriter.setResource(new FileSystemResource("src/main/resources/people.xml"));
        itemWriter.setRootTagName("peoples");
        itemWriter.setOverwriteOutput(true);

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(people.class);

        itemWriter.setMarshaller(marshaller);

        return itemWriter;
    }

    @Bean
    public Step csvStep(StepBuilderFactory factory,
                        ItemReader peopleItemReader,
                        ItemWriter peopleItemWriter) {
        return factory
                .get("csvStep")
                .chunk(10)
                .reader(peopleItemReader)
                .processor(processor())
                .writer(peopleItemWriter)
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory factory,
                   Step csvStep, PeopleListener peopleListener) {
        return factory
                .get("job")
                .incrementer(new RunIdIncrementer())
                .start(csvStep)
                .listener(peopleListener)
                .build();

    }
}
