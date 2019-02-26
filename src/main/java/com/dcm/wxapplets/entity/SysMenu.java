package com.dcm.wxapplets.entity;

import com.dcm.wxapplets.base.BaseModel;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "菜单")
public class SysMenu extends BaseModel<SysMenu> {
    private static final long serialVersionUID = 5673375019770866430L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /** 菜单名 */
    @ApiModelProperty(value = "菜单名")
    @NotEmpty(message = "菜单名不能为空")
    @Size(max = 50, message = "菜单名不能超过50个字符")
    private String name;

    /** 菜单层级code */
    @ApiModelProperty(value = "菜单层级code")
    @NotEmpty(message = "菜单层级code不能为空")
    @Size(max = 50, message = "菜单层级code不能超过50个字符")
    private String code;

    /** 菜单等级(1-2) */
    @ApiModelProperty(value = "菜单等级(1-2)")
    @Max(value = 2, message = "菜单等级(1-2)")
    @Min(value = 1, message = "菜单等级(1-2)")
    private Integer level;

    /** 菜单图标 */
    @ApiModelProperty(value = "菜单图标")
    @Size(max = 50, message = "菜单图标不能超过50个字符")
    private String icon;

    /** 菜单uri(以/开头) */
    @ApiModelProperty(value = "菜单uri(以/开头)")
    @NotEmpty(message = "菜单uri(以/开头)不能为空")
    @Size(max = 100, message = "菜单uri(以/开头)不能超过100个字符")
    private String uri;

    /** 启用？(0-false, 1-true,默认1) */
    @ApiModelProperty(value = "启用？(0-false, 1-true,默认1)")
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

    /** 下一级菜单集合 */
    @ApiModelProperty(value = "下一级菜单集合")
    private List<SysMenu> children = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public SysMenu setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysMenu setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getCode() {
        return code;
    }

    public SysMenu setCode(String code) {
        this.code = code == null ? null : code.trim();
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public SysMenu setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public SysMenu setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
        return this;
    }

    public String getUri() {
        return uri;
    }

    public SysMenu setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
        return this;
    }

    public Integer getEnable() {
        return enable;
    }

    public SysMenu setEnable(Integer enable) {
        this.enable = enable;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SysMenu setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
        return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysMenu setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysMenu setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public SysMenu setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysMenu setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }
}
