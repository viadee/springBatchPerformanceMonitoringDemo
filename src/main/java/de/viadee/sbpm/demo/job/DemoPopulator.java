package de.viadee.sbpm.demo.job;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DemoPopulator {

	public List<DemoItem> populateDemoData() {
		List<DemoItem> items = Arrays.asList(
				new DemoItem(1, 11, "Item 1"),
				new DemoItem(1, 12, "Item 2"),
				new DemoItem(1, 13, "Item 3"),
				new DemoItem(2, 21, "Item 4"),
				new DemoItem(2, 22, "Item 5"),
				new DemoItem(2, 23, "Item 6"),
				new DemoItem(3, 31, "Item 7"),
				new DemoItem(3, 32, "Item 8"),
				new DemoItem(3, 33, "Item 9"));

		return new LinkedList<>(items);
	}

}
