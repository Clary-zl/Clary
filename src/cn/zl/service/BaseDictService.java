package cn.zl.service;

import java.util.List;

import cn.zl.pojo.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> getBaseDictsByCode(String code);
}