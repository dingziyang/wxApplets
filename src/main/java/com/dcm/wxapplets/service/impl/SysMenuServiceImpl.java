package com.dcm.wxapplets.service.impl;

import com.dcm.wxapplets.base.BaseServiceImpl;
import com.dcm.wxapplets.entity.SysMenu;
import com.dcm.wxapplets.query.SysMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcm.wxapplets.dao.SysMenuDao;
import com.dcm.wxapplets.service.SysMenuService;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,SysMenuExample,Long> implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;

	@Override
	public void setDao() {
		this.baseDao = sysMenuDao;
	}

}