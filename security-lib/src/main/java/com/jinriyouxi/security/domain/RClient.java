package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.jinriyouxi.common.TtyObject;
import com.jinriyouxi.common.constant.Status;
import io.swagger.annotations.ApiModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;


@Data
@ApiModel("客户端对象")
@TableName("r_client")
public class RClient extends TtyObject implements ClientDetails {


  /**
   * 默认授权域
   */
  public static final String DEFAULT_SCOPE = "uface";
  /**
   * 7天默认access token过期时间
   */
  public static final Integer DEFAULT_ACCESS_TOKEN_VALID_SECONDS = (int) TimeUnit.DAYS.toSeconds(7);
  /**
   * 30天refresh token 过期时间
   */
  public static final Integer DEFAULT_REFRESH_TOKEN_VALID_SECONDS = (int) TimeUnit.DAYS.toSeconds(30);

  /**
   * 客户端类型，默认系统客户端，无需分配权限，只有系统可以操作调用
   */
  public static final Integer TYPE_DEFAULT = 1;
  /**
   * 客户端类型，api客户端，如果注册为api客户端，该类型的客户端暴露给客户操作
   */
  public static final Integer TYPE_API_CLIENT = 2;
  /**
   * 客户端授权默认模式
   */
  public static final String[] DEFAULT_CLIENT_AUTHORIZATION_TYPES = {"authorization_code", "implicit", "password", "refresh_token"};
  public static final String[] API_CLIENT_AUTHORIZATION_TYPES = {"client_credentials", "refresh_token"};

  private static final long serialVersionUID = 1L;
  /**
   * 客户端授权名称
   */
  @TableField( "name")
  private String name;
  /**
   * 授权key
   */
  @TableField("client_key")
  private String clientKey;

  /**
   * 授权密钥
   */
  @TableField("client_secret")
  private String clientSecret;

  /**
   * 明文密钥
   */
  @TableField("raw_client_secret")
  private String rawClientSecret;

  /**
   * 是否启用
   */
  @TableField("status")
  private Status status;


  /**
   * 重定向uris
   */
  @TableField("redirect_uris")
  private String redirectUris;

  @TableField("scopes")
  private String scopes;

  @TableField("resource_ids")
  private String resourceIds;

  /**
   * 客户端授权模式
   */
  @TableField("authorized_grant_types")
  private String authorizedGrantTypes;

  /**
   * access token 有效时间(秒)
   */
  @TableField( "access_token_valid_seconds")
  private Integer accessTokenValiditySeconds;

  /**
   * refresh token 有效时间(秒)
   */
  @TableField("refresh_token_valid_second")
  private Integer refreshTokenValidSeconds;

  @TableField(exist = false)
  private List<RPermission> permissionList;


  //=======================Client Details Implementation==============================

  /**
   * 返回客户端id
   *
   * @return
   */
  @Override
  public String getClientId() {
    return clientKey;
  }

  /**
   * 返回是否需要验证。
   * 我们设置了密钥就需要验证，没设置就不需要
   *
   * @return
   */
  @Override
  public boolean isSecretRequired() {
    return !StringUtils.isEmpty(clientSecret);
  }

  @Override
  public String getClientSecret() {
    return this.clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }


  /**
   * 是否限制访问域，我们选择否
   *
   * @return
   */
  @Override
  public boolean isScoped() {
    return false;
  }



  /**
   * 获取这个客户端所有的权限列表
   *
   * @return
   */
  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return this.permissionList.stream().collect(Collectors.toList());
  }

  @Override
  public boolean isAutoApprove(String scope) {
    return true;
  }

  /**
   * 固定 password,client_credentials,refresh_token
   *
   * @return
   */
  @Override
  public Set<String> getAuthorizedGrantTypes() {
    HashSet<String> hashSet;
    if (StringUtils.isEmpty(this.authorizedGrantTypes)) {
      hashSet = new HashSet<>(Arrays.asList(this.authorizedGrantTypes.split(",")));
    } else {
      hashSet = new HashSet<>(Arrays.asList(DEFAULT_CLIENT_AUTHORIZATION_TYPES));
    }
    return hashSet;
  }

  /**
   * 注册的回调页面
   *
   * @return
   */
  @Override
  public Set<String> getRegisteredRedirectUri() {
    Set<String> uris;
    if (StringUtils.isEmpty(this.redirectUris)) {
      uris = new HashSet<>(Arrays.asList(this.redirectUris.split(",")));
    } else {
      uris = new HashSet<>();
    }
    return uris;
  }

  /**
   * 默认设置 有效期 7天
   *
   * @return
   */
  @Override
  public Integer getAccessTokenValiditySeconds() {
    if (this.accessTokenValiditySeconds != null && this.accessTokenValiditySeconds > 0) {
      return accessTokenValiditySeconds;
    }
    return (int) TimeUnit.DAYS.toSeconds(7);
  }

  /**
   * 默认设置refresh_token有效期 30天
   *
   * @return
   */
  @Override
  public Integer getRefreshTokenValiditySeconds() {
    if (this.refreshTokenValidSeconds != null && this.refreshTokenValidSeconds > 0) {
      return refreshTokenValidSeconds;
    }
    return (int) TimeUnit.DAYS.toSeconds(30);
  }

  /**
   * 返回额外信息
   *
   * @return
   */
  @Override
  public Map<String, Object> getAdditionalInformation() {
    Map<String, Object> info = new HashMap<>(1);
    info.put("client_name", this.name);
    return info;
  }

  @Override
  public Set<String> getResourceIds() {
    Set<String> resources ;
    if (StringUtils.isEmpty(this.resourceIds)) {
      resources = new HashSet<>(Arrays.asList(this.resourceIds.split(",")));
    } else {
      resources = new HashSet<>();
    }
    return resources;
  }

  /**
   * 返回一个空集合表示没有被限定访问域
   *
   * @return
   */
  @Override
  public Set<String> getScope() {
    Set<String> scopes;
    if (StringUtils.isEmpty(this.scopes)) {
      scopes = new HashSet<>(Arrays.asList(this.scopes.split(",")));
    } else {
      scopes = new HashSet<>();
    }
    return scopes;
  }

}