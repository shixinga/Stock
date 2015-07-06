package com.service.impl;

import com.dao.ReadRecodeDao;
import com.dao.impl.ReadRecodeDaoFileImpl;
import com.service.ReadService;

public class ReadRecodeServiceImpl implements ReadService {

	private ReadRecodeDao dao;
	
	
	public ReadRecodeServiceImpl() {

		dao = new ReadRecodeDaoFileImpl();
	}

	//读取收藏记录
	//返回读取到的记录字符串，最后要靠调用display函数显示出来
	/* (non-Javadoc)
	 * @see com.service.ReadService#read()
	 */
	@Override
	public String read() {
		return dao.readData();
	}

	/* (non-Javadoc)
	 * @see com.service.ReadService#Search(java.lang.String)
	 */
	@Override
	public String Search(String Date) {
		return dao.Search(Date);
	}
}
