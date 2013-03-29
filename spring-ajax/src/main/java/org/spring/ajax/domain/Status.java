package org.spring.ajax.domain;

public class Status {

	private String status;

	public Status(SearchStatus statusEnum) {
		status = statusEnum.toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
