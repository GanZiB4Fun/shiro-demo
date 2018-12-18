package com.ganzib.service;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GanZiB
 * Date: 2018-12-18
 * Time: 13:54
 */
public interface SysPermissionService {
    Set<String> getPermissionByUserId(Long id);
}
