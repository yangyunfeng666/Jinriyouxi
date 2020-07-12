package com.jinriyouxi.security.constants;

public enum UserRoleEnum {
  SYSTEM_ADMIN("系统管理员"),
  ADMIN("管理员"),
  TEST("测试"),
  NORMAL("普通角色"),
  OPRATION("运营");

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  UserRoleEnum(String code) {
    this.code = code;
  }
}
