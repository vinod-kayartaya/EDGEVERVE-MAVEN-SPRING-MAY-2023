package com.infosys.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcProductDao implements ProductDao {

	public JdbcProductDao() {
		log.trace("JdbcProductDao constructor called");
	}

	@Override
	public int count() throws DaoException {
		int pc = 77;
		log.trace("returning {} as count from JdbcProductDao", pc);
		return pc;
	}

}
