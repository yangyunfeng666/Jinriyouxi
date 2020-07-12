package com.jinriyouxi.security.dto;

import com.jinriyouxi.security.enums.MemberType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

@ApiModel
public class RUserInfoDTO implements Serializable {

  @ApiModelProperty("用户类型")
  private MemberType memberType;

  @ApiModelProperty("用户页面")
  private List<RMenuDTO> menuList;

  @ApiModelProperty("用户等级")
  private int level;

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public MemberType getMemberType() {
    return memberType;
  }

  public void setMemberType(MemberType memberType) {
    this.memberType = memberType;
  }

  public List<RMenuDTO> getMenuList() {
    return menuList;
  }

  public void setMenuList(List<RMenuDTO> menuList) {
    this.menuList = menuList;
  }
}
