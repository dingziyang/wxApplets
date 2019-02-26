package com.dcm.wxapplets.entity;

import com.dcm.wxapplets.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "系统用户")
public class SysUser extends BaseModel<SysUser> {
    private static final long serialVersionUID = 7107384493786397201L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /** 用户名(Max=50) */
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 50, message = "用户名不能超过50个字符")
    private String userName;

    /** 昵称 */
    @ApiModelProperty(value = "昵称")
    @NotEmpty(message = "昵称不能为空")
    @Size(max = 50, message = "昵称不能超过50个字符")
    private String nickName;

    /** 密码 */
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 50, message = "密码不能超过50个字符")
    private String pwd;

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /** 是否工人(0-否，1-是，默认0） */
    @ApiModelProperty(value = "是否工人(0-否，1-是，默认0）")
    @Max(value = 1, message = "是否工人(0-否，1-是，默认0）")
    @Min(value = 0, message = "是否工人(0-否，1-是，默认0）")
    private Integer worker;

    /** 部门id */
    @ApiModelProperty(value = "部门id")
    @Min(value = 1, message = "部门id必须大于0的整数")
    private Long depId;

    /** 微信号 */
    @ApiModelProperty(value = "微信号")
    private String wx;

    /** 微信openid */
    @ApiModelProperty(value = "微信openid")
    private String openid;

    /** 性别(1-男，2-女) */
    @ApiModelProperty(value = "性别(1-男，2-女)")
    private Integer sex;

    /** 地址 */
    @ApiModelProperty(value = "地址")
    private String address;

    /** 是否启用?（0-false， 1-true，默认1） */
    @ApiModelProperty(value = "启用?（0-false， 1-true，默认1）")
    @Max(value = 1, message = "启用？(0-false, 1-true,默认1)")
    @Min(value = 0, message = "启用？(0-false, 1-true,默认1)")
    private Integer enable;

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public SysUser setId(Long id) {
        this.id = id;
		return this;
    }

    public String getUserName() {
        return userName;
    }

    public SysUser setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
		return this;
    }

    public String getNickName() {
        return nickName;
    }

    public SysUser setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
		return this;
    }

    public String getPwd() {
        return pwd;
    }

    public SysUser setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
		return this;
    }

    public String getPhone() {
        return phone;
    }

    public SysUser setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
		return this;
    }

    public Integer getWorker() {
        return worker;
    }

    public SysUser setWorker(Integer worker) {
        this.worker = worker;
		return this;
    }

    public Long getDepId() {
        return depId;
    }

    public SysUser setDepId(Long depId) {
        this.depId = depId;
		return this;
    }

    public String getWx() {
        return wx;
    }

    public SysUser setWx(String wx) {
        this.wx = wx == null ? null : wx.trim();
		return this;
    }

    public String getOpenid() {
        return openid;
    }

    public SysUser setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
		return this;
    }

    public Integer getSex() {
        return sex;
    }

    public SysUser setSex(Integer sex) {
        this.sex = sex;
		return this;
    }

    public String getAddress() {
        return address;
    }

    public SysUser setAddress(String address) {
        this.address = address == null ? null : address.trim();
		return this;
    }

    public Integer getEnable() {
        return enable;
    }

    public SysUser setEnable(Integer enable) {
        this.enable = enable;
		return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysUser setCreateBy(Long createBy) {
        this.createBy = createBy;
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysUser setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public SysUser setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
		return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysUser setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
		return this;
    }
}
