package de.viadee.sbpm.demo.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class DemoProcessor implements ItemProcessor<DemoItem, DemoItem> {

	@Override
	public DemoItem process(DemoItem item) throws Exception {

		int delay = item.getId() % 4 == 0 ? 5000 : 500;

		Thread.sleep(delay);

		return item;
	}

}
