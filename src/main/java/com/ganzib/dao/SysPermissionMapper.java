package com.ganzib.dao;

import com.ganzib.entity.SysPermission;
import java.util.List;

public interface SysPermissionMapper {
    int insert(SysPermission record);

    List<SysPermission> selectAll();
}