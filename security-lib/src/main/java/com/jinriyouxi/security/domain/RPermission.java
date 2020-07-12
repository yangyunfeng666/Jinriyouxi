package com.jinriyouxi.security.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinriyouxi.common.TtyObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;


/**
 * 系统权限,鉴权的最细粒度
 */
@ApiModel("系统权限")
@TableName("r_permission")
public class RPermission extends TtyObject implements GrantedAuthority {

    private static final long serialVersionUID = -1L;

    /**
     * 权限显示名称
     */
    @ApiModelProperty("权限显示名称")
    @TableField( "name")
    private String name;

    /**
     * 服务
     */
    @ApiModelProperty("服务名称")
    @TableField("service")
    private String service;

    /**
     * controller控制层
     */
    @ApiModelProperty("controller")
    @TableField("controller")
    private String controller;

    /**
     * 方法名字
     */
    @ApiModelProperty("方法名字")
    @TableField("method")
    private String method;

    /**
     * 标识是否为系统高级权限 1 是 0 不是
     */
    @ApiModelProperty("标识是否为系统高级权限 1 是 0 不是")
    @TableField("is_root_permission")
    private Integer isRootPermission;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


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

    public Integer getIsRootPermission() {
        return isRootPermission;
    }

    public void setIsRootPermission(Integer isRootPermission) {
        this.isRootPermission = isRootPermission;
    }

    /**
     * 返回资源编号
     *
     * @return
     */
    @Override
    public String getAuthority() {
        return this.method+"_"+this.controller+"_"+this.service;
    }

}
