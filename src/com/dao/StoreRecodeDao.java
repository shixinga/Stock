package com.dao;

public interface StoreRecodeDao {

	//收藏记录(没有参数和返回值，直接调用就可以收藏记录）
	public abstract void store();

	//清空收藏记录（把所有收藏记录清空，但收藏记录文件还在）
	public abstract void clear();

}