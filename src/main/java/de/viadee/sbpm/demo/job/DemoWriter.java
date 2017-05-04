package de.viadee.sbpm.demo.job;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class DemoWriter implements ItemWriter<DemoItem> {

	@Override
	public void write(List<? extends DemoItem> items) throws Exception {
		items.stream().forEach(item -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Nothing to do
			}
			System.out.println(item.getName());
		});
	}

}
