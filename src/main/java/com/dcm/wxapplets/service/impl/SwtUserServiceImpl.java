package com.dcm.wxapplets.service.impl;

import com.dcm.wxapplets.base.BaseServiceImpl;
import com.dcm.wxapplets.dao.SwtUserDao;
import com.dcm.wxapplets.entity.SwtUser;
import com.dcm.wxapplets.query.SwtUserExample;
import com.dcm.wxapplets.service.SwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SwtUserServiceImpl extends BaseServiceImpl<SwtUser,SwtUserExample,Long> implements SwtUserService {

	@Autowired
	private SwtUserDao swtUserDao;

	@Override
	public void setDao() {
		this.baseDao = swtUserDao;
	}

	@Override
	public SwtUser getById(Long id) {
		return this.swtUserDao.selectByPrimaryKey(id);
	}
}