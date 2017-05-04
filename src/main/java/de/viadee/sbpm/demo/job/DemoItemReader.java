package de.viadee.sbpm.demo.job;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;

public class DemoItemReader extends IteratorItemReader<DemoItem> {

	public DemoItemReader(Iterable<DemoItem> iterable) {
		super(iterable);
	}

	@Override
	public DemoItem read() throws Exception, UnexpectedInputException, ParseException {
		Thread.sleep(100);
		return super.read();
	}

}
