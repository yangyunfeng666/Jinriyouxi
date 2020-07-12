/**
 * Copyright (c) 2011-2014 All Rights Reserved.
 */
package com.jinriyouxi.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 * @version $Id: TtyObject.java 2019年3月12日 上午11:05:12 $
 */
public class TtyObject implements Serializable {
	private static final long serialVersionUID = -1133660048887177718L;
	
	/**
	 * 主健ID
	 */
	@ApiModelProperty("主健ID")
	@TableId(value = "id", type = IdType.AUTO)
	private long id;
	
	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	@TableField("create_date")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	/**
	 * 更新人
	 */
	@ApiModelProperty("更新人")
	@TableField("update_user")
	private String updateUser;

	/**
	 * 更新日期
	 */
	@ApiModelProperty("更新日期")
	@TableField("update_date")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	/**
	 * 创建人
	 */
	@ApiModelProperty("创建人")
	@TableField("create_user")
	private String createUser;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	@TableField("remark")
	private String remark;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
