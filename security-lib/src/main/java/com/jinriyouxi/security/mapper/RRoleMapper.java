package com.jinriyouxi.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinriyouxi.security.domain.RRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RRoleMapper extends BaseMapper<RRole> {

  List<RRole> selectByUserId(@Param("userId") Long usreId);

}
