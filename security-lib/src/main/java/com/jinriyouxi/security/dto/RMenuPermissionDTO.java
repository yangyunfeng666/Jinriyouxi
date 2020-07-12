package com.jinriyouxi.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("权限")
public class RMenuPermissionDTO {

  @ApiModelProperty("页面id")
  private Long menuId;

  @ApiModelProperty("权限id")
  private Long permissionId;

  @ApiModelProperty("权限名字")
  private String name;

  private String service;

  private String controller;

  private String method;

  private String authority;

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getController() {
    return controller;
  }

  public void setController(String controller) {
    this.controller = controller;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getAuthority() {
    return this.method+"_"+this.controller+"_"+this.service;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
