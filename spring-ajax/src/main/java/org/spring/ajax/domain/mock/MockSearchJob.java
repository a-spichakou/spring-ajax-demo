package org.spring.ajax.domain.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.spring.ajax.domain.LogRecord;

/**
 * 
 * @author aliaksandr_spichakou
 * Mock search job
 */
public class MockSearchJob implements Serializable {
	private static final long serialVersionUID = 4074792142557480058L;
	private List<LogRecord> records=new ArrayList<LogRecord>();

	public List<LogRecord> getRecords() {
		return records;
	}

	public void setRecords(List<LogRecord> records) {
		this.records = records;
	}
}
