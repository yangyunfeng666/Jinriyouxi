package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("页面权限关联表")
@TableName("r_menu_permission")
public class RMenuPermission extends TtyObject {

  @ApiModelProperty("页面id")
  @TableField("menu_id")
  private Long menuId;


  @ApiModelProperty("权限id")
  @TableField("permission_id")
  private Long permissionId;

  public Long getMenuId() {
    return menuId;
  }

  public void setMenuId(Long menuId) {
    this.menuId = menuId;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }
}
