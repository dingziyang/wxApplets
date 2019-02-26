package com.dcm.wxapplets.entity;

import com.dcm.wxapplets.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "菜单角色")
public class SysMenuRole extends BaseModel<SysMenuRole> {
    private static final long serialVersionUID = 4786060515189043216L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /** 菜单角色名 */
    @ApiModelProperty(value = "菜单角色名")
    @NotEmpty(message = "菜单角色名不能为空")
    @Size(max = 50, message = "菜单角色名不能超过50个字符")
    private String name;

    /** 菜单角色等级 */
    @ApiModelProperty(value = "菜单角色等级(1-3)")
    @Max(value = 3, message = "菜单角色等级(1-3)")
    @Min(value = 1, message = "菜单角色等级(1-3)")
    private Integer level;

    /** 排序号 */
    @ApiModelProperty(value = "排序号(1-99)")
    @Max(value = 99, message = "排序号(1-99)")
    @Min(value = 1, message = "排序号(1-99)")
    private Integer idx;

    /** 启用？(0-false,1-true) */
    @ApiModelProperty(value = "启用？(0-false,1-true)")
    @Max(value = 1, message = "启用？(0-false, 1-true,默认1)")
    @Min(value = 0, message = "启用？(0-false, 1-true,默认1)")
    private Integer enable;

    /** 必须启用？(0-false, 1-true，默认0) */
    @ApiModelProperty(value = "必须启用？(0-false, 1-true，默认0)")
    @Max(value = 1, message = "启用？(0-false, 1-true,默认1)")
    @Min(value = 0, message = "启用？(0-false, 1-true,默认1)")
    private Integer mustEnable;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    @Size(max = 255, message = "备注不能超过255个字符")
    private String remark;

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public SysMenuRole setId(Long id) {
        this.id = id;
		return this;
    }

    public String getName() {
        return name;
    }

    public SysMenuRole setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    public Integer getLevel() {
        return level;
    }

    public SysMenuRole setLevel(Integer level) {
        this.level = level;
		return this;
    }

    public Integer getIdx() {
        return idx;
    }

    public SysMenuRole setIdx(Integer idx) {
        this.idx = idx;
		return this;
    }

    public Integer getEnable() {
        return enable;
    }

    public SysMenuRole setEnable(Integer enable) {
        this.enable = enable;
		return this;
    }

    public Integer getMustEnable() {
        return mustEnable;
    }

    public SysMenuRole setMustEnable(Integer mustEnable) {
        this.mustEnable = mustEnable;
		return this;
    }

    public String getRemark() {
        return remark;
    }

    public SysMenuRole setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
		return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysMenuRole setCreateBy(Long createBy) {
        this.createBy = createBy;
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysMenuRole setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public SysMenuRole setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
		return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysMenuRole setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
		return this;
    }
}
