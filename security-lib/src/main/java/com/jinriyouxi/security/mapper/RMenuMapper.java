package com.jinriyouxi.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinriyouxi.security.domain.RMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RMenuMapper extends BaseMapper<RMenu> {

  List<RMenu> getMenus(@Param("userId") String userId);
}
