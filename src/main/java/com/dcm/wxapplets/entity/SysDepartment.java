package com.dcm.wxapplets.entity;

import com.dcm.wxapplets.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "部门")
public class SysDepartment extends BaseModel<SysDepartment> {
    private static final long serialVersionUID = 2092600215244725147L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /** 部门名 */
    @ApiModelProperty(value = "部门名")
    @NotEmpty(message = "部门名不能为空")
    @Size(max = 50, message = "部门名不能超过50个字符")
    private String name;

    /** 部门详情 */
    @ApiModelProperty(value = "部门详情")
    @Size(max = 1000, message = "部门详情不能超过1000个字符")
    private String details;

    /** 是否启用?（0-false， 1-true，默认1） */
    @ApiModelProperty(value = "启用?（0-false， 1-true，默认1）")
    @Max(value = 1, message = "启用？(0-false, 1-true,默认1)")
    @Min(value = 0, message = "启用？(0-false, 1-true,默认1)")
    private Integer enable;

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

    public SysDepartment setId(Long id) {
        this.id = id;
		return this;
    }

    public String getName() {
        return name;
    }

    public SysDepartment setName(String name) {
        this.name = name == null ? null : name.trim();
		return this;
    }

    public String getDetails() {
        return details;
    }

    public SysDepartment setDetails(String details) {
        this.details = details == null ? null : details.trim();
		return this;
    }

    public Integer getEnable() {
        return enable;
    }

    public SysDepartment setEnable(Integer enable) {
        this.enable = enable;
		return this;
    }

    public String getRemark() {
        return remark;
    }

    public SysDepartment setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
		return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysDepartment setCreateBy(Long createBy) {
        this.createBy = createBy;
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysDepartment setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public SysDepartment setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
		return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysDepartment setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
		return this;
    }
}
