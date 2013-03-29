package org.spring.ajax.domain;

/**
 * 
 * @author aliaksandr_spichakou Log data
 * 
 */
public class LogRecord {

	private String id;
	private String server;
	private String logDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getLogDescription() {
		return logDescription;
	}

	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

}
