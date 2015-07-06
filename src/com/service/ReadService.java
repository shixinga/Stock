package com.service;

public interface ReadService {

	//读取收藏记录
	//返回读取到的记录字符串，最后要靠调用display函数显示出来
	public abstract String read();

	public abstract String Search(String Date);

}