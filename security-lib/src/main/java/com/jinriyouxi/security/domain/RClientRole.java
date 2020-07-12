package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户角色关联表")
@TableName("r_client_role")
public class RClientRole extends TtyObject {

  @ApiModelProperty("客户端id")
  @TableField("client_id")
  private Long clientId;


  @ApiModelProperty("角色id")
  @TableField("role_id")
  private Long roleId;

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
}
