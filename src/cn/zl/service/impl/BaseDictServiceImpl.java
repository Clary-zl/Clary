package cn.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zl.dao.BaseDictMapper;
import cn.zl.pojo.BaseDict;
import cn.zl.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	
	@Override
	public List<BaseDict> getBaseDictsByCode(String code) {
		return baseDictMapper.getBaseDictsByCode(code);
	}
}