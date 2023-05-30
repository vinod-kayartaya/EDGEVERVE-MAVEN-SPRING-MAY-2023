package com.infosys.dao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyProductDao implements ProductDao {
	
	public DummyProductDao() {
		log.trace("DummyProductDao constructor called");
	}

	@Override
	public int count() throws DaoException {
		int pc = 999;
		log.trace("returning {} as count from DummyProductDao", pc);
		return pc;
	}

}
