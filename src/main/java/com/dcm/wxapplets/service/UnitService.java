package com.dcm.wxapplets.service;

import com.dcm.wxapplets.base.BaseService;
import com.dcm.wxapplets.entity.Unit;
import com.dcm.wxapplets.query.UnitExample;

import java.util.List;

public interface UnitService extends BaseService<Unit,UnitExample,Long> {

    /**
     * @author dcm
     * @date 2018-6-26 9:47
     * @Description: 获取所有单位
     * @throws
     */
    List<Unit> getAll();

    /**
      * @author dcm
      * @date 2018-7-2 13:59
      * @Description: 获取根单位以及整个单位树
      * @throws
      */
    Unit getRootTree();

    /**
      * @author dcm
      * @date 2018-8-9 9:22
      * @Description: 获取所有子集
      * @param: unit
      * @throws
      */
    List<Unit> getChildren(Unit unit);

    /**
     * @author dcm
     * @date 2018-6-27 14:31
     * @Description: 删除单位，同时删除【用户-单位】 关联表的数据
     * @param: ids
     * @return int
     */
    int deleteByIds(List<Long> ids);
}