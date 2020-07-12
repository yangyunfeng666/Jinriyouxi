package com.jinriyouxi.security.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import com.jinriyouxi.common.constant.Status;
import com.jinriyouxi.security.enums.MenuType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@TableName("r_menu")
public class RMenu extends TtyObject {

  @ApiModelProperty("page URL")
  @TableField("url")
  private String url;

  @ApiModelProperty("页面名字")
  @TableField("name")
  private String name;

  @ApiModelProperty("父页面id")
  @TableField("parent_menu_id")
  private Long parentMenuId;


  @ApiModelProperty("页面类型")
  @TableField("type")
  private MenuType type;


  @ApiModelProperty("ENABLE 可用 UNABLE不可用")
  @TableField("status")
  private Status status;

  public MenuType getType() {
    return type;
  }

  public void setType(MenuType type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParentMenuId() {
    return parentMenuId;
  }

  public void setParentMenuId(Long parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
