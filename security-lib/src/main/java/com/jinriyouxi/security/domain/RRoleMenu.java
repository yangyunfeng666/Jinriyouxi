package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色页面关联表")
@TableName("r_role_menu")
public class RRoleMenu extends TtyObject {

  @ApiModelProperty("页面id")
  @TableField("menu_id")
  private Long menuId;


  @ApiModelProperty("角色id")
  @TableField("role_id")
  private Long roleId;

  public Long getMenuId() {
    return menuId;
  }

  public void setMenuId(Long menuId) {
    this.menuId = menuId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
}
