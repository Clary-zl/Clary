package cn.zl.dao;

import java.util.List;

import cn.zl.pojo.BaseDict;

public interface BaseDictMapper {
	
	public List<BaseDict> getBaseDictsByCode(String code);
}