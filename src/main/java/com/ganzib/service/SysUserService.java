package com.ganzib.service;

import com.ganzib.entity.SysUser;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GanZiB
 * Date: 2018-12-18
 * Time: 13:51
 */
public interface SysUserService {
    SysUser findByUsername(String username);
}
