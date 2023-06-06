package com.infosys.dao;

public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 2257483844276985300L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
