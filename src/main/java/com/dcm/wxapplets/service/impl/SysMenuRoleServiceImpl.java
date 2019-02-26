package com.dcm.wxapplets.service.impl;

import com.dcm.wxapplets.base.BaseServiceImpl;
import com.dcm.wxapplets.entity.SysMenuRole;
import com.dcm.wxapplets.query.SysMenuRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcm.wxapplets.dao.SysMenuRoleDao;
import com.dcm.wxapplets.service.SysMenuRoleService;

@Service
public class SysMenuRoleServiceImpl extends BaseServiceImpl<SysMenuRole,SysMenuRoleExample,Long> implements SysMenuRoleService {

	@Autowired
	private SysMenuRoleDao sysMenuRoleDao;

	@Override
	public void setDao() {
		this.baseDao = sysMenuRoleDao;
	}

}