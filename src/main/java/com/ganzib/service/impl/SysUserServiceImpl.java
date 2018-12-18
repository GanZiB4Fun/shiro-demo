package com.ganzib.service.impl;

import com.ganzib.entity.SysUser;
import com.ganzib.mapper.SysUserMapper;
import com.ganzib.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GanZiB
 * Date: 2018-12-18
 * Time: 13:55
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String username) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("nickname",username);
        return sysUserMapper.selectOneByExample(example);
    }
}
