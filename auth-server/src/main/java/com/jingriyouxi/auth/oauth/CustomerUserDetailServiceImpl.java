package com.jingriyouxi.auth.oauth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.jinriyouxi.security.domain.MyUserDetail;
import com.jinriyouxi.security.domain.RPermission;
import com.jinriyouxi.security.domain.RRole;
import com.jinriyouxi.security.domain.RUser;
import com.jinriyouxi.security.mapper.RPermissionMapper;
import com.jinriyouxi.security.mapper.RRoleMapper;
import com.jinriyouxi.security.mapper.RUserMapper;
import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultMsg;
import com.jinriyouxi.common.exception.ResponseException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "customerUserDetailServiceImpl")
public class CustomerUserDetailServiceImpl implements UserDetailsService {


  @Resource
  private RUserMapper rUserMapper;

  @Resource
  private RRoleMapper rRoleMapper;

  @Resource
  private RPermissionMapper permissionMapper;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    QueryWrapper<RUser> memberQueryWrapper = new QueryWrapper<>();
    memberQueryWrapper.eq("login_id", name);
    List<RUser> user = rUserMapper.selectList(memberQueryWrapper);
    if (user.isEmpty()) {
      throw  ResponseException.of(ResultCode.FAILURE, ResultMsg.USER_NOT_EXIST.getMsg());
    } else if (user.size() == 1) {
      List<RPermission> list = permissionMapper.selectByUserId(user.get(0).getId());
      List<RRole> role = rRoleMapper.selectByUserId(user.get(0).getId());
      RRole rRole = null;
      if (!role.isEmpty()) {
        rRole = role.get(0);
      }
      return new MyUserDetail(user.get(0),list,rRole);
    } else {
      throw ResponseException.of(ResultCode.FAILURE, ResultMsg.USER_EXIST_MANY.getMsg());
    }
  }



}
