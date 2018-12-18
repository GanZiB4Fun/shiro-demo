package com.ganzib.dao;

import com.ganzib.entity.SysRolePermission;
import java.util.List;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    List<SysRolePermission> selectAll();
}