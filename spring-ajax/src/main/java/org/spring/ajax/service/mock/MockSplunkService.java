package org.spring.ajax.service.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.ajax.domain.LogRecord;
import org.spring.ajax.domain.SearchStatus;
import org.spring.ajax.domain.mock.MockSearchJob;
import org.spring.ajax.service.ISplunkService;

/**
 * 
 * @author aliaksandr_spichakou
 * Mock implementation of Splunk communication services
 */
public class MockSplunkService implements ISplunkService{
	
	private static Map<String, MockSearchJob> jobs = new HashMap<String, MockSearchJob>();

	public String startSearch() {
		final MockSearchJob job = new MockSearchJob();
		fillByRundom(job);
		long currentTimeMillis = System.currentTimeMillis();
		final String key = currentTimeMillis+"";
		jobs.put(key, job);
		return key;
	}
	
	private MockSearchJob fillByRundom(MockSearchJob job)
	{
		final List<LogRecord> records = job.getRecords();
		final LogRecord record = new LogRecord();
		record.setId(System.currentTimeMillis()+"");
		record.setLogDescription("Log Description: " + System.currentTimeMillis());
		record.setServer("Server: "+System.currentTimeMillis());
		records.add(record);
		return job;
	}

	public SearchStatus getSearchStatus(String searchId) {
		final long currentTime = System.currentTimeMillis();
		final MockSearchJob mockSearchJob = jobs.get(searchId);
		if(mockSearchJob==null)
		{
			return SearchStatus.NOT_FOUND;
		}
		if(currentTime-Long.parseLong(searchId)<30000)
		{
			fillByRundom(mockSearchJob);
			return SearchStatus.RUNNING;
		}
		else
		{
			return SearchStatus.DONE;
		}
	}

	public List<LogRecord> getResults(String searchId) {
		final MockSearchJob mockSearchJob = jobs.get(searchId);
		if(mockSearchJob==null)
		{
			return null;
		}
		return mockSearchJob.getRecords();
	}

}
