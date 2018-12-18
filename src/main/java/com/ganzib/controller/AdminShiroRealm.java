//package com.ganzib.shirodemo.controller;
//
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
///**
// * Created with IntelliJ IDEA. Description: User: GanZiB Date: 2018-12-13 Time: 10:00
// */
//public class AdminShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private SysUserService sysUserService;
//    @Autowired
//    private ShiroService shiroService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        SysUserDTO userInfo = (SysUserDTO) principals.getPrimaryPrincipal();
//        //用户权限列表
//        Set<String> permsSet = shiroService.getUserPermissions(userInfo.getUserId());
//        //用户角色
//        Set<String> userRoles = shiroService.getUserRoles(userInfo.getUserId());
//        authorizationInfo.setStringPermissions(permsSet);
//        authorizationInfo.setRoles(userRoles);
//        return authorizationInfo;
//    }
//
//    /* 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。 */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //获取用户的输入的账号.
//        String username = (String) token.getPrincipal();
//        //通过username从数据库中查找 User对象，如果找到，没找到.
//        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        SysUserDTO userInfo = sysUserService.getUserByUsernameOrPhone(username);
//        if (userInfo == null) {
//            return null;
//        }
//        if (userInfo.getStatus() == UserAttrEnum.AdminUserStatus.INVALID.getCode()) { //账户冻结
//            throw new LockedAccountException();
//        }
//        return new SimpleAuthenticationInfo(userInfo, //用户名
//                userInfo.getPassword(), //密码
//                ByteSource.Util.bytes(userInfo.getSalt()), //salt=username+salt
//                getName() //realm name
//        );
//    }
//}
