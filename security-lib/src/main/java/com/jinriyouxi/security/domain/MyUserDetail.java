package com.jinriyouxi.security.domain;

import com.jinriyouxi.security.constants.UserRoleEnum;
import com.jinriyouxi.security.enums.MemberType;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户token认证用户
 */
public class MyUserDetail implements UserDetails {

  private static final long serialVersionUID = -1374075475556995574L;

  private String id;


  private boolean rememerMe;

  public boolean isRememerMe() {
    return rememerMe;
  }

  public void setRememerMe(boolean rememerMe) {
    this.rememerMe = rememerMe;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  private String password;

  private String userName;

  private MemberType userType;

  private UserRoleEnum role;

  public UserRoleEnum getRole() {
    return role;
  }

  public void setRole(UserRoleEnum role) {
    this.role = role;
  }

  private Collection<? extends GrantedAuthority> authorities;


  public MyUserDetail(RUser user, List<RPermission> permissionList,RRole rRole){
    this.id = Long.toString(user.getId());
    this.password = user.getPassword();
    this.userName = user.getLoginId();
    this.authorities = permissionList;
    this.userType = user.getUserType();
    if (role != null) {
      this.role = rRole.getCode();
    }
  }

  public MemberType getUserType() {
    return userType;
  }

  public void setUserType(MemberType userType) {
    this.userType = userType;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * 重新读取数据
   * @return
   */
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setAuthorities(
      Collection<? extends GrantedAuthority> authorities) {
    this.authorities = authorities;
  }



  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  /**
   * 在token的username上标识用户的标识
   * @return
   */
  @Override
  public String getUsername() {
    return    this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String toString() {
    return "MyUserDetail{" +
        "id='" + id + '\'' +
        ", rememerMe=" + rememerMe +
        ", password='" + password + '\'' +
        ", userName='" + userName + '\'' +
        ", userType=" + userType +
        ", authorities=" + authorities +
        '}';
  }
}
