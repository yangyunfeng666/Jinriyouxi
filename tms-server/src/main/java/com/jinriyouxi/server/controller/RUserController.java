package com.jinriyouxi.server.controller;

import com.jinriyouxi.common.constant.ResultJson;
import com.jinriyouxi.security.SecurityContextUtil;
import com.jinriyouxi.security.domain.MyUserDetail;
import com.jinriyouxi.security.dto.RUserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户Controller")
@RestController
@RequestMapping("/user")
public class RUserController {

  @ApiOperation("获取menu")
  @PreAuthorize("hasAnyAuthority('queryMenu_user_oms')")
  @RequestMapping(value = "/queryMenu", method = RequestMethod.POST)
  public ResultJson<RUserInfoDTO> queryMenu() {
    MyUserDetail myUserDetail = SecurityContextUtil.currentUser();
    return ResultJson.of_success(myUserDetail);
  }





}
