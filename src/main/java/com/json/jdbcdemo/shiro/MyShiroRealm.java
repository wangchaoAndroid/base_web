package com.json.jdbcdemo.shiro;

import com.json.jdbcdemo.pojo.SysPermission;
import com.json.jdbcdemo.pojo.SysRole;
import com.json.jdbcdemo.pojo.User;
import com.json.jdbcdemo.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


//public class MyShiroRealm extends AuthorizingRealm {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Resource
//    private LoginService userService;
//
//    //权限信息，包括角色以及权限
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        //如果授权部分没有传入User对象，这里只能取到userName
//        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
//        User user  = (User)principals.getPrimaryPrincipal();
//
//        for(SysRole role:user.getRoleList()){
//            authorizationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermissions()){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
//        return authorizationInfo;
//    }
//
//    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
//            throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
//        //获取用户的输入的账号.
//        String userName = (String)token.getPrincipal();
//        logger.info(userName);
//        System.out.println(token.getCredentials());
//        //通过username从数据库中查找 User对象，如果找到，没找到.
//        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        User user = userService.authrationUser(userName,"");
//        System.out.println("----->>user="+user);
//        if(user == null){
//            return null;
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user, //这里传入的是user对象，比对的是用户名，，但是直接传入用户名也没错在授权部分就需要自己重新从数据库里取权限
//                user.getPassword(), //密码
//                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
//                getName()  //realm name
//        );
//        return authenticationInfo;
//    }
//
//}
