package com.service.impl;

import com.dao.impl.StoreRecordDaoFileImpl;
import com.service.StoreService;

//门面模式
public class StoreRecodeServiceImpl implements StoreService {

	private StoreRecordDaoFileImpl dao;

	public StoreRecodeServiceImpl(String a1,String a2,String b1,String b2,
			String c1,String c2,String d1,String d2,String e1,String e2 ) {
		this.dao = new StoreRecordDaoFileImpl(a1, a2, b1, b2, c1, c2, d1, d2, e1, e2);
	} 
	
	//将要保存在10个数字连成字符串
	public	String getData() {
		return this.dao.getData();
	}
	
	//将字符串保存到txt文件中
	public void printWriter(String st) {
		this.dao.printWriter(st);
	}
	
	//收藏记录(没有参数和返回值，直接调用就可以收藏记录）
	/* (non-Javadoc)
	 * @see com.service.StoreService#store()
	 */
	@Override
	public void store() {
		this.dao.store();
	}
	 //清空收藏记录（把所有收藏记录清空，但收藏记录文件还在）
	 /* (non-Javadoc)
	 * @see com.service.StoreService#clear()
	 */
	@Override
	public void clear() {
		 this.dao.clear();
	 }
}
