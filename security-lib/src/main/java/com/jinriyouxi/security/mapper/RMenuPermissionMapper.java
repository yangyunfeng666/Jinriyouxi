package com.jinriyouxi.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinriyouxi.security.domain.RMenuPermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RMenuPermissionMapper extends BaseMapper<RMenuPermission> {

  int batchInsert(@Param("list") List<RMenuPermission> list );

}
