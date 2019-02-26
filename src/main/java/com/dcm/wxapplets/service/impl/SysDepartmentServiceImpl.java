package com.dcm.wxapplets.service.impl;

import com.dcm.wxapplets.base.BaseServiceImpl;
import com.dcm.wxapplets.entity.SysDepartment;
import com.dcm.wxapplets.query.SysDepartmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcm.wxapplets.dao.SysDepartmentDao;
import com.dcm.wxapplets.service.SysDepartmentService;

@Service
public class SysDepartmentServiceImpl extends BaseServiceImpl<SysDepartment,SysDepartmentExample,Long> implements SysDepartmentService {

	@Autowired
	private SysDepartmentDao sysDepartmentDao;

	@Override
	public void setDao() {
		this.baseDao = sysDepartmentDao;
	}

}