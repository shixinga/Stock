package com.dao;

public interface ReadRecodeDao {

	//读取收藏记录
	//返回读取到的记录字符串，最后要靠调用display函数显示出来
	public abstract String readData();

	//查找某一天的收藏记录（参数日期的格式为：xxxx/yy/zz）
	//返回符合日期的记录字符串，最后要靠调用display函数显示出来
	public abstract String Search(String Date);

}