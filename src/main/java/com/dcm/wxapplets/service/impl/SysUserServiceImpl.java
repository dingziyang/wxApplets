package com.dcm.wxapplets.service.impl;

import com.dcm.wxapplets.base.BaseServiceImpl;
import com.dcm.wxapplets.entity.SysUser;
import com.dcm.wxapplets.query.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcm.wxapplets.dao.SysUserDao;
import com.dcm.wxapplets.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,SysUserExample,Long> implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void setDao() {
		this.baseDao = sysUserDao;
	}

}