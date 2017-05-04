package de.viadee.sbpm.demo.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.viadee.spring.batch.infrastructure.Configurator;

@Configuration
@ComponentScan
@Import(Configurator.class)
public class DemoJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DemoPopulator populator;

	@Autowired
	private DemoProcessor processor;

	@Autowired
	private DemoWriter writer;

	@Autowired
	private DemoPartitioner partitioner;

	@Bean
	public Job demoJob() {
		return jobBuilderFactory.get("demoJob")
				.start(partitionStep())
				.build();
	}

	@Bean
	public Step demoStep() {
		return stepBuilderFactory.get("demoStep")
				.<DemoItem, DemoItem> chunk(100)
				.reader(reader(null, null))
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	public Step partitionStep() {
		return stepBuilderFactory.get("partitionStep")
				.partitioner(demoStep())
				.partitioner("demoStep", partitioner)
				.gridSize(3)
				.build();
	}

	@Bean
	@StepScope
	public ItemReader<DemoItem> reader(
			@Value("#{stepExecutionContext[fromId]}") Integer fromId,
			@Value("#{stepExecutionContext[toId]}") Integer toId) {
		List<DemoItem> demoData = populator.populateDemoData()
				.stream()
				.filter(demoItem -> demoItem.between(fromId, toId))
				.collect(Collectors.toList());
		return new DemoItemReader(demoData);
	}

	@Bean
	public DemoPartitioner partitioner() {
		return new DemoPartitioner();
	}

}
