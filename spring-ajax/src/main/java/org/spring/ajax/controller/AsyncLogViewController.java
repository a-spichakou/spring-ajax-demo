package org.spring.ajax.controller;

import java.util.List;

import org.spring.ajax.domain.LogRecord;
import org.spring.ajax.domain.SearchStatus;
import org.spring.ajax.domain.Status;
import org.spring.ajax.service.ISplunkService;
import org.spring.ajax.service.mock.MockSplunkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author aliaksandr_spichakou
 * Spring Ajax MVC controller
 */
@Controller
@RequestMapping("/view")
public class AsyncLogViewController {
	private ISplunkService service = new MockSplunkService();

	/**
	 * @param searchId - search Splunk id
	 * @return list of log records
	 */
	@RequestMapping(value = "/results/{searchId}", method = RequestMethod.GET)
	public @ResponseBody List<LogRecord> getLogs(@PathVariable String searchId) {
		return service.getResults(searchId);
	}

	/**
	 * Start search method
	 * @return Splunk search id
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startSearchSession(ModelMap model) {
		final String startSearch = service.startSearch();
		model.addAttribute("searchId",startSearch);
		return "logs";
	}

	/**
	 * Get search status
	 * @param searchId
	 * @return search status
	 */
	@RequestMapping(value = "/status/{searchId}", method = RequestMethod.GET)
	public @ResponseBody Status getStatus(@PathVariable String searchId) {
		final SearchStatus searchStatus = service.getSearchStatus(searchId);
		final Status status = new Status(searchStatus);
		return status;
	}

}
