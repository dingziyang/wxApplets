package com.dcm.wxapplets.controller.pc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.dcm.wxapplets.config.CtlResultAnnotation;
import com.dcm.wxapplets.config.CtlValidAnnotation;
import com.dcm.wxapplets.config.ResultVO;
import com.dcm.wxapplets.entity.SwtUser;
import com.dcm.wxapplets.exception.DataExistedException;
import com.dcm.wxapplets.exception.FormValidException;
import com.dcm.wxapplets.query.SwtUserExample;
import com.dcm.wxapplets.service.SwtUserService;
import com.dcm.wxapplets.utils.SessionUserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Api(value = "/pc/swtUser", description = "用户接口")
@RestController
@RequestMapping("/pc/swtUser")
public class SwtUserCtl {

	@Autowired
	private SwtUserService swtUserService;

	@ApiOperation(value = "pageList", notes = "分页查询，支持：用户名，微信号，手机号，性别", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/pageList")
	@CtlResultAnnotation
	public ResultVO<PageInfo<SwtUser>> pageList(SwtUser user, @RequestParam(defaultValue="1") int pageNum,
											 @RequestParam(defaultValue="10") int pageSize, HttpServletRequest request){

		ResultVO<PageInfo<SwtUser>> vo = new ResultVO<>();

		// obj 与 example关联
		SwtUserExample example = new SwtUserExample();
		example.setOrderByClause("update_time desc");
		if ( user != null) {
			SwtUserExample.Criteria c = example.createCriteria();
			if(!StringUtils.isEmpty(user.getUsername())){
				c.andUsernameLike("%" + user.getUsername() + "%");
			}
			if(!StringUtils.isEmpty(user.getWx())){
				c.andWxEqualTo("%" + user.getWx() + "%");
			}
			if(!StringUtils.isEmpty(user.getPhone())){
				c.andPhoneEqualTo("%" + user.getPhone() + "%");
			}
			if(user.getSex() != null){
				c.andSexEqualTo(user.getSex());
			}
		}
		PageHelper.startPage(pageNum, pageSize);
		List<SwtUser> lst = this.swtUserService.selectByExample(example);
		vo.setData(new PageInfo<>(lst));
		return vo;
	}

	@ApiOperation(value = "create", notes = "增", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/create")
	@CtlResultAnnotation
	@CtlValidAnnotation
	public ResultVO<Integer> create(@RequestBody @Valid SwtUser user, BindingResult validResult, HttpServletRequest request){

		ResultVO<Integer> vo = new ResultVO<>();

		SwtUserExample userExample = new SwtUserExample();
		userExample.createCriteria().andUsernameEqualTo(user.getUsername());
		if(!StringUtils.isEmpty(user.getPhone())){
			userExample.or().andPhoneEqualTo(user.getPhone());
		}
		List<SwtUser> existUsers = this.swtUserService.selectByExample(userExample);
		if (CollectionUtils.isEmpty(existUsers)) {
			this.swtUserService.insertSelective(user);
			vo.setData(1);
		} else {
			throw new DataExistedException("用户名["+ user.getUsername() +"] 或手机号[ "
					+ user.getPhone() +" ] 已存在，不可重复创建");
		}
		return vo;
	}

//	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public Object update(@RequestBody SwtUser swtUser){
//
//		return this.swtUserService.updateByPrimaryKeySelective(swtUser);
//
//	}
//
//	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/view",method=RequestMethod.GET)
//	public Object view(@RequestParam Long id){
//
//		return this.swtUserService.selectByPrimaryKey(id);
//
//	}
//
//
//	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/delete",method=RequestMethod.POST)
//	public Object delete(@RequestBody Map<String,Long> ids){
//
//		return this.swtUserService.deleteByPrimaryKey(ids.get("id"));
//
//	}
	
}
