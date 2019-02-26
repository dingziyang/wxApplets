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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

//	@ApiOperation(value="新增", notes="新增实体", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
//	})
//	@PostMapping("/create")
//	@CtlResultAnnotation
//	@CtlValidAnnotation
//	public ResultVO<Long> create(@RequestBody @Valid ZuifanCondition zuifanCondition, BindingResult validResult, String userId){
//
//		ResultVO<Long> vo = new ResultVO<>();
//		if(StringUtils.isEmpty(userId)){
//			throw new ValidateFailedException("参数不合法：[ userId ] 不能为空");
//		}
//		ZuifanConditionExample example = new ZuifanConditionExample();
//		example.createCriteria().andCnameEqualTo(zuifanCondition.getCname()).andCreateByEqualTo(userId);
//		List<ZuifanCondition> list = this.zuifanConditionService.selectByExample(example);
//		if(!CollectionUtils.isEmpty(list) && list.size() == 1){
//			throw new ValidateFailedException("条件名：[ " + zuifanCondition.getCname() + " ] 在用户 [ " + userId + " ] 下已存在，不可重复创建! ");
//		}
//
//		zuifanCondition.setCreateBy(userId);
//		zuifanCondition.setUpdateBy(userId);
//		vo.setData(this.zuifanConditionService.insertZuiFanCondition(zuifanCondition));
//		return vo;
//	}

//	@ApiOperation(value="更新", notes="根据主键指定更新实体，并根据传过来的实体信息来更新实体详情", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long"),
//			@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
//			//@ApiImplicitParam(name = "zuifanCondition", value = "实体", required = true, dataType = "ZuifanCondition")
//	})
//	@PutMapping("/{id}")
//	@CtlResultAnnotation
//	@CtlValidAnnotation
//	public ResultVO<Integer> update(@PathVariable Long id,@RequestBody @Valid ZuifanCondition zuifanCondition, String userId,BindingResult validResult){
//
//		ResultVO<Integer> vo = new ResultVO<>();
//		zuifanCondition.setUpdateBy(userId);
//		vo.setData(Integer.parseInt(this.zuifanConditionService.updateByPrimaryKeySelective(zuifanCondition) + ""));
//		return vo;
//	}

//	@ApiOperation(value="详情", notes="根据主键获取实体详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long")
//	})
//	@GetMapping("/{id}")
//	@CtlResultAnnotation
//	public ResultVO<ZuifanCondition> view(@PathVariable Long id){
//
//		ResultVO<ZuifanCondition> vo = new ResultVO<>();
//		vo.setData(this.zuifanConditionService.selectByPrimaryKey(id));
//		return vo;
//	}
//
//	@ApiOperation(value = "单个删除", notes = "根据主键删除实体", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long")
//	})
//	@DeleteMapping("/{id}")
//	@CtlResultAnnotation
//	public ResultVO<Integer> delete(@PathVariable Long id){
//
//		ResultVO<Integer> vo = new ResultVO<>();
//		vo.setData(this.zuifanConditionService.deleteByPrimaryKey(id));
//		return vo;
//	}
//
//	@ApiOperation(value="批量删除", notes="根据主键数组删除实体集合", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
//	@DeleteMapping("/delete")
//	@CtlResultAnnotation
//	public ResultVO<Integer> delete(@RequestBody List<Long> ids){
//
//		ResultVO<Integer> vo = new ResultVO<>();
//		vo.setData(this.zuifanConditionService.deleteByPrimaryKeys(ids));
//		return vo;
//
//	}
	
}
