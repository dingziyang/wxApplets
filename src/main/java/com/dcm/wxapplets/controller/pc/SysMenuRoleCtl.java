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

import com.dcm.wxapplets.entity.SysMenuRole;
import com.dcm.wxapplets.query.SysMenuRoleExample;
import com.dcm.wxapplets.service.SysMenuRoleService;

@Api(value = "/pc/sysMenuRole", description = "接口")
@RestController
@RequestMapping("/pc/sysMenuRole")
public class SysMenuRoleCtl{

	@Autowired
	private SysMenuRoleService sysMenuRoleService;

	@ApiOperation(value="分页查询", notes="根据实体及分页参数，获取带有实体列表的分页数据", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码，默认值1", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", value = "每页数量，默认值10", dataType = "int")
	})
	@GetMapping("/pageList")
	@CtlResultAnnotation
	public ResultVO<PageInfo<SysMenuRole>> pageList(

		SysMenuRole sysMenuRole,
		@RequestParam(defaultValue = "1") int pageNum,
		@RequestParam(defaultValue = "10") int pageSize,
		HttpServletRequest request){

		ResultVO<PageInfo<SysMenuRole>> vo = new ResultVO<>();
		SysMenuRoleExample example = new SysMenuRoleExample();
		example.setOrderByClause(" id ");
		
		setQuery(example, sysMenuRole);
		
		PageHelper.startPage(pageNum,pageSize);
		List<SysMenuRole> lst = this.sysMenuRoleService.selectByExample(example);
		vo.setData(new PageInfo<>(lst));
		return vo;

	}

	@ApiOperation(value="列表查询", notes="根据实体，获取实体列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/list")
	@CtlResultAnnotation
	public ResultVO<List<SysMenuRole>> list(

		SysMenuRole sysMenuRole){

		ResultVO<List<SysMenuRole>> vo = new ResultVO<>();
		SysMenuRoleExample example = new SysMenuRoleExample();

		setQuery(example, sysMenuRole);

		List<SysMenuRole> lst = this.sysMenuRoleService.selectByExample(example);
		vo.setData(lst);
		return vo;

	}

	@ApiOperation(value="新增", notes="新增实体", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sysMenuRole", value = "实体", required = true, dataType = "SysMenuRole")
	})
	@PostMapping
	@CtlResultAnnotation
	@CtlValidAnnotation
	public ResultVO<Integer> create(@RequestBody @Valid SysMenuRole sysMenuRole,BindingResult validResult){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(Integer.parseInt(this.sysMenuRoleService.insertSelective(sysMenuRole) + ""));
		return vo;

	}

	@ApiOperation(value="更新", notes="根据主键指定更新实体，并根据传过来的实体信息来更新实体详情", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String"),
		@ApiImplicitParam(name = "sysMenuRole", value = "实体", required = true, dataType = "SysMenuRole")
	})
	@PutMapping("/{id}")
	@CtlResultAnnotation
	@CtlValidAnnotation
	public ResultVO<Integer> update(@PathVariable Long id, @RequestBody @Valid SysMenuRole sysMenuRole,BindingResult validResult){

		ResultVO<Integer> vo = new ResultVO<>();
		sysMenuRole.setId(id);
		vo.setData(Integer.parseInt(this.sysMenuRoleService.updateByPrimaryKeySelective(sysMenuRole) + ""));
		return vo;

	}

	@ApiOperation(value="详情", notes="根据主键获取实体详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
	})
	@GetMapping("/{id}")
	@CtlResultAnnotation
	public ResultVO<SysMenuRole> view(@PathVariable Long id){

		ResultVO<SysMenuRole> vo = new ResultVO<>();
		vo.setData(this.sysMenuRoleService.selectByPrimaryKey(id));
		return vo;

	}

	@ApiOperation(value = "单个删除", notes = "根据主键删除实体", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
	})
	@DeleteMapping("/{id}")
	@CtlResultAnnotation
	public ResultVO<Integer> delete(@PathVariable Long id){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(this.sysMenuRoleService.deleteByPrimaryKey(id));
		return vo;

	}

	@ApiOperation(value="批量删除", notes="根据主键数组删除实体集合", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping("/delete")
	@CtlResultAnnotation
	public ResultVO<Integer> delete(@RequestBody List<Long> ids){

		ResultVO<Integer> vo = new ResultVO<>();
		vo.setData(this.sysMenuRoleService.deleteByPrimaryKeys(ids));
		return vo;

	}
	
	private void setQuery(SysMenuRoleExample example, SysMenuRole sysMenuRole){
		//TODO SysMenuRole 与 example关联
	}
	
}
