package com.ganzib.service.impl;

import com.ganzib.entity.SysPermission;
import com.ganzib.entity.SysRole;
import com.ganzib.entity.SysRolePermission;
import com.ganzib.entity.SysUserRole;
import com.ganzib.mapper.SysPermissionMapper;
import com.ganzib.mapper.SysRoleMapper;
import com.ganzib.mapper.SysRolePermissionMapper;
import com.ganzib.mapper.SysUserRoleMapper;
import com.ganzib.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GanZiB
 * Date: 2018-12-18
 * Time: 13:55
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> getPermissionByUserId(Long id) {
        Example example = new Example(SysUserRole.class);
        example.createCriteria().andEqualTo("uid",id);
        SysUserRole sysUserRole = sysUserRoleMapper.selectOneByExample(example);
        example = new Example(SysRole.class);
        example.createCriteria().andEqualTo("rid",sysUserRole.getRid());
        SysRole sysRole = sysRoleMapper.selectOneByExample(example);
        example = new Example(SysRolePermission.class);
        example.createCriteria().andEqualTo("id",sysRole.getId());
        SysRolePermission sysRolePermission = sysRolePermissionMapper.selectOneByExample(example);
        example = new Example(SysPermission.class);
        example.createCriteria().andEqualTo("pid",sysRolePermission.getPid());
        List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(example);
        return sysPermissions.stream().map(SysPermission::getUrl).collect(Collectors.toSet());
    }

}
