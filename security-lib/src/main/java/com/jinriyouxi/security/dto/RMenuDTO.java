package com.jinriyouxi.security.dto;

import com.jinriyouxi.common.constant.Status;
import java.util.Date;
import java.util.List;

public class RMenuDTO {

  private Long id;

  private String url;

  private String name;

  private Status status;

  private Date createDate;

  private Long parentMenuId;

  public Long getParentMenuId() {
    return parentMenuId;
  }

  public void setParentMenuId(Long parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  private List<RMenuDTO> children ;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public List<RMenuDTO> getChildren() {
    return children;
  }

  public void setChildren(List<RMenuDTO> children) {
    this.children = children;
  }
}
