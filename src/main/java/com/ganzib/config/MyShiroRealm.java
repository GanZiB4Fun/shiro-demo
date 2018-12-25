package com.ganzib.config;

import com.ganzib.entity.SysUser;
import com.ganzib.service.SysPermissionService;
import com.ganzib.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GanZiB
 * Date: 2018-12-18
 * Time: 14:00
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userInfo = (SysUser) principals.getPrimaryPrincipal();
        Set<String> permissions = sysPermissionService.getPermissionByUserId(userInfo.getId());
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
//        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo = userService.findByUsername(username);
//        System.out.println("----->>userInfo="+userInfo);
        if (userInfo == null) {
            return null;
        }
        if (userInfo.getStatus() == 1) { //账户冻结
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPswd(), //密码
//                ByteSource.Util.bytes(userInfo.get()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
