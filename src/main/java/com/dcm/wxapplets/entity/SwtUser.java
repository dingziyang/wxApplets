package com.dcm.wxapplets.entity;

import com.dcm.wxapplets.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
  * @author xusanduo
  * @date 2019/2/24 17:21
  * @Description: 用户
  * @return
  * @throws
  */
@ApiModel(description = "用户")
public class SwtUser extends BaseModel<SwtUser> {
    private static final long serialVersionUID = 1363355110091825323L;

    /** 自增主键 */
    @ApiModelProperty(value = "自增主键")
    private Long id;

    /** 用户名(Max=50) */
    @ApiModelProperty(value = "用户名(Max=50)")
    @Size(max = 50, message = "用户名最大长度50个字符")
    @NotEmpty
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码")
    @Size(max = 100, message = "密码最大长度100个字符")
    @NotEmpty
    private String pwd;

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    @Size(max = 20, message = "手机号最大长度20个字符")
    private String phone;

    /** 微信号 */
    @ApiModelProperty(value = "微信号")
    @Size(max = 50, message = "微信号最大长度50个字符")
    private String wx;

    /** 微信openid */
    @ApiModelProperty(value = "微信openid")
    @Size(max = 100, message = "微信openid最大长度100个字符")
    private String openid;

    /** 性别(1-男，2-女) */
    @ApiModelProperty(value = "性别(1-男，2-女)")
    @Max(value = 2, message = "性别(1-男，2-女)")
    @Min(value = 1, message = "性别(1-男，2-女)")
    private Integer sex;

    /** 地址 */
    @ApiModelProperty(value = "地址")
    @Size(max = 150, message = "地址最大长度150个字符")
    private String address;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public SwtUser setId(Long id) {
        this.id = id;
		return this;
    }

    public String getUsername() {
        return username;
    }

    public SwtUser setUsername(String username) {
        this.username = username == null ? null : username.trim();
		return this;
    }

    public String getPwd() {
        return pwd;
    }

    public SwtUser setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
		return this;
    }

    public String getPhone() {
        return phone;
    }

    public SwtUser setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
		return this;
    }

    public String getWx() {
        return wx;
    }

    public SwtUser setWx(String wx) {
        this.wx = wx == null ? null : wx.trim();
		return this;
    }

    public String getOpenid() {
        return openid;
    }

    public SwtUser setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
		return this;
    }

    public Integer getSex() {
        return sex;
    }

    public SwtUser setSex(Integer sex) {
        this.sex = sex;
		return this;
    }

    public String getAddress() {
        return address;
    }

    public SwtUser setAddress(String address) {
        this.address = address == null ? null : address.trim();
		return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SwtUser setCreateTime(Date createTime) {
        this.createTime = createTime;
		return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SwtUser setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
		return this;
    }
}
