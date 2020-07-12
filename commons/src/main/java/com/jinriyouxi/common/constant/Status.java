package com.jinriyouxi.common.constant;

public enum  Status {
  /**
   *有效
   */
  ENABLE("ENABLE"),
  /**
   * 无效
   */
  UNABLE("UNABLE");

  private String  text;

  Status(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
