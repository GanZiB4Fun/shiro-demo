package com.ganzib.dao;

import com.ganzib.entity.SysUser;
import java.util.List;

public interface SysUserMapper {
    int insert(SysUser record);

    List<SysUser> selectAll();
}