package com.ganzib.dao;

import com.ganzib.entity.SysRole;
import java.util.List;

public interface SysRoleMapper {
    int insert(SysRole record);

    List<SysRole> selectAll();
}