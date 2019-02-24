package com.dcm.wxapplets.service;


import com.dcm.wxapplets.base.BaseService;
import com.dcm.wxapplets.entity.SwtUser;
import com.dcm.wxapplets.query.SwtUserExample;

public interface SwtUserService extends BaseService<SwtUser,SwtUserExample,Long> {

    SwtUser getById(Long id);
}