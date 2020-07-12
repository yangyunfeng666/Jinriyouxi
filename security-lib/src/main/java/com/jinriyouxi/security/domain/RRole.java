package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import com.jinriyouxi.common.constant.Status;
import com.jinriyouxi.security.constants.UserRoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


@ApiModel
@TableName("r_role")
public class RRole extends TtyObject implements Serializable {

  @ApiModelProperty("角色code")
  @TableField("code")
  private UserRoleEnum code;

  @ApiModelProperty("角色名字")
  @TableField("name")
  private String name;

  @ApiModelProperty("状态 1 有效 0禁用")
  @TableField("status")
  private Status status;

  public UserRoleEnum getCode() {
    return code;
  }

  public void setCode(UserRoleEnum code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
