package com.sapient.test.response;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Meta meta;
	private T body;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public ResponseEntity(Meta meta, T body) {
		super();
		this.meta = meta;
		this.body = body;
	}

	public ResponseEntity() {
		super();
	}

}
