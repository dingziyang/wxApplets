package com.dcm.wxapplets.controller.pc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.dcm.wxapplets.config.ResultVO;
import com.dcm.wxapplets.config.CtlResultAnnotation;
import com.dcm.wxapplets.config.CtlValidAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.dcm.wxapplets.entity.SysUser;
import com.dcm.wxapplets.query.SysUserExample;
import com.dcm.wxapplets.service.SysUserService;

@Api(value = "/sysUser", description = "接口")
@RestController
@RequestMapping("/sysUser")
public class SysUserCtl{

	@Autowired
	private SysUserService sysUserService;
	
	@ApiOperation(value="新增", notes="新增实体", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sysUser", value = "实体", required = true, dataType = "SysUser")
	})
	@PostMapping
	@CtlResultAnnotation
	@CtlValidAnnotation
	public ResultVO<Integer> create(@RequestBody @Valid SysUser sysUser,BindingResult validResult){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(Integer.parseInt(this.sysUserService.insertSelective(sysUser) + ""));
		return vo;

	}
	
	@ApiOperation(value = "单个删除", notes = "根据主键删除实体", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long")
	})
	@DeleteMapping("/{id}")
	@CtlResultAnnotation
	public ResultVO<Integer> delete(@PathVariable Long id){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(this.sysUserService.deleteByPrimaryKey(id));
		return vo;

	}

	@ApiOperation(value="批量删除", notes="根据主键数组删除实体集合", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping("/delete")
	@CtlResultAnnotation
	public ResultVO<Integer> delete(@RequestBody List<Long> ids){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(this.sysUserService.deleteByPrimaryKeys(ids));
		return vo;

	}
	
	@ApiOperation(value="更新", notes="根据主键指定更新实体，并根据传过来的实体信息来更新实体详情", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long"),
		@ApiImplicitParam(name = "sysUser", value = "实体", required = true, dataType = "SysUser")
	})
	@PutMapping("/{id}")
	@CtlResultAnnotation
	@CtlValidAnnotation
	public ResultVO<Integer> update(@PathVariable Long id, @RequestBody @Valid SysUser sysUser,BindingResult validResult){

		ResultVO<Integer> vo = new ResultVO<>();
		sysUser.setId(id);
		vo.setData(Integer.parseInt(this.sysUserService.updateByPrimaryKeySelective(sysUser) + ""));
		return vo;

	}
	
	@ApiOperation(value="详情", notes="根据主键获取实体详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Long")
	})
	@GetMapping("/{id}")
	@CtlResultAnnotation
	public ResultVO<SysUser> view(@PathVariable Long id){

		ResultVO<SysUser> vo = new ResultVO<>();
		vo.setData(this.sysUserService.selectByPrimaryKey(id));
		return vo;

	}
	
	@ApiOperation(value="列表查询", notes="根据实体，获取实体列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/list")
	@CtlResultAnnotation
	public ResultVO<List<SysUser>> list(

		SysUser sysUser){

		ResultVO<List<SysUser>> vo = new ResultVO<>();
		SysUserExample example = new SysUserExample();

		setQuery(example, sysUser);

		List<SysUser> lst = this.sysUserService.selectByExample(example);
		vo.setData(lst);
		return vo;

	}
	
	@ApiOperation(value="分页查询", notes="根据实体及分页参数，获取带有实体列表的分页数据", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码，默认值1", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", value = "每页数量，默认值10", dataType = "int")
	})
	@GetMapping("/pageList")
	@CtlResultAnnotation
	public ResultVO<PageInfo<SysUser>> pageList(

		SysUser sysUser,
		@RequestParam(defaultValue = "1") int pageNum,
		@RequestParam(defaultValue = "10") int pageSize,
		HttpServletRequest request){

		ResultVO<PageInfo<SysUser>> vo = new ResultVO<>();
		SysUserExample example = new SysUserExample();
		example.setOrderByClause(" id ");
		
		setQuery(example, sysUser);
		
		PageHelper.startPage(pageNum,pageSize);
		List<SysUser> lst = this.sysUserService.selectByExample(example);
		vo.setData(new PageInfo<>(lst));
		return vo;
	}
	
	// 设置查询条件
	private void setQuery(SysUserExample example, SysUser sysUser){
		//TODO SysUser 与 example关联
	}
	
}
