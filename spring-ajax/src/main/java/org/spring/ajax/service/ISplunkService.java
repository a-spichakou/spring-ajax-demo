package org.spring.ajax.service;

import java.util.List;

import org.spring.ajax.domain.LogRecord;
import org.spring.ajax.domain.SearchStatus;

/**
 * 
 * @author aliaksandr_spichakou
 * Splunk communication service
 */
public interface ISplunkService {
	
	/**
	 * Start search service
	 * @return Splunk search id
	 */
	public String startSearch();
	
	/**
	 * Get search status
	 * @param searchId
	 * @return
	 */
	public SearchStatus getSearchStatus(String searchId);
	
	/**
	 * Get search results
	 * @param searchId
	 * @return list of logs entries
	 */
	public List<LogRecord> getResults(String searchId);

}
