package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色权限关联表")
@TableName("r_role_permission")
public class RRolePermission extends TtyObject {

  @ApiModelProperty("页面id")
  @TableField("role_id")
  private Long roleId;

  @ApiModelProperty("角色id")
  @TableField("permission_id")
  private Long permissionId;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }
}
