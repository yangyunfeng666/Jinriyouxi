package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.security.enums.MemberType;
import com.jinriyouxi.common.TtyObject;
import com.jinriyouxi.common.constant.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


@ApiModel
@TableName("r_user")
public class RUser extends TtyObject implements Serializable {

  @ApiModelProperty("用户原理表的id")
  @TableField("origin_id")
  private Long orginId;

  @ApiModelProperty("登陆账账户")
  @TableField("login_id")
  private String loginId;

  @ApiModelProperty("账户名称")
  @TableField("name")
  private String name;

  @ApiModelProperty("用户类型 ")
  @TableField("user_type")
  private MemberType userType;

  @ApiModelProperty("密码")
  @TableField("password")
  private String password;

  @ApiModelProperty("状态 1 有效 0禁用")
  @TableField("status")
  private Status status;

  @ApiModelProperty("等级")
  @TableField("level")
  private Integer level;

  @ApiModelProperty("邮件")
  @TableField("email")
  private String  email;

  @ApiModelProperty("真实姓名")
  @TableField("real_name")
  private String  realName;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Long getOrginId() {
    return orginId;
  }

  public void setOrginId(Long orginId) {
    this.orginId = orginId;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MemberType getUserType() {
    return userType;
  }

  public void setUserType(MemberType userType) {
    this.userType = userType;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
