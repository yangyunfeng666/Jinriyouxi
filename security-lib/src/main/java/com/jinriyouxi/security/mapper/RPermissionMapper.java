package com.jinriyouxi.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinriyouxi.security.domain.RPermission;
import com.jinriyouxi.security.dto.RMenuPermissionDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RPermissionMapper extends BaseMapper<RPermission> {

  List<RPermission> selectByClientId(@Param("clientId") Long clientId);

  /**
   * 根据selectByUserId查询用户的权限
   * @param id
   * @return
   */
  List<RPermission> selectByUserId(@Param("id") Long id);

  List<RMenuPermissionDTO> selectByMenuId(@Param("menuId") Long id);
}
