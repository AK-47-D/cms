package com.ak47.cms.cms.config;

import com.ak47.cms.cms.dto.ManageUserDto;
import com.ak47.cms.cms.entity.ManagePermins;
import com.ak47.cms.cms.entity.ManageRole;
import com.ak47.cms.cms.entity.ManageUser;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.service.ManagePerminsService;
import com.ak47.cms.cms.service.ManageRoleService;
import com.ak47.cms.cms.service.ManageUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取用户的角色和权限信息
 * Created by bamboo on 2017/5/10.
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private ManageUserService manageUserService;
    @Autowired
    private ManageRoleService manageRoleService;
    @Autowired
    private ManagePerminsService managePerminsService;
    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        Result<ManageUserDto> result = manageUserService.findByUser(token.getUsername(),new String(token.getPassword()));
        if(!result.isSuccess()){
            throw new AuthenticationException(result.getMessage());
        }
        result.getResult().setManageRoleList(manageRoleService.findByUserId(result.getResult().getId()));
        result.getResult().setManagePerminsList(managePerminsService.findByUserId(result.getResult().getId()));
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("manageUser",result.getResult());
        return new SimpleAuthenticationInfo(result.getResult(),token.getPassword() , getName());
//        UUser hasUser = uUserDao.findByName(token.getUsername());
////        String md5Pwd = new Md5Hash("123", "lucare",2).toString();
//        if (hasUser != null) {
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            List<URole> rlist = uRoleDao.findRoleByUid(hasUser.getId());//获取用户角色
//            List<UPermission> plist = uPermissionDao.findPermissionByUid(hasUser.getId());//获取用户权限
//            List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
//            List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
//            for (URole role : rlist) {
//                roleStrlist.add(role.getName());
//            }
//            for (UPermission uPermission : plist) {
//                perminsStrlist.add(uPermission.getName());
//            }
//            hasUser.setRoleStrlist(roleStrlist);
//            hasUser.setPerminsStrlist(perminsStrlist);
////            Session session = SecurityUtils.getSubject().getSession();
////            session.setAttribute("user", hasUser);//成功则放入session
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());
//        }
    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        ManageUserDto manageUserDto = (ManageUserDto) principalCollection.getPrimaryPrincipal();
        if(manageUserDto != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(manageUserDto.getManageRoleList().stream().map(manageRole -> manageRole.getRoleName()).collect(Collectors.toList()));
            info.addStringPermissions(manageUserDto.getManagePerminsList().stream().map(managePermins -> managePermins.getPerminsName()).collect(Collectors.toList()));
            return info;
        }
//        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
////        String loginName = (String) super.getAvailablePrincipal(principalCollection);
//        UUser user = (UUser) principalCollection.getPrimaryPrincipal();
////        //到数据库查是否有此对象
////        User user = null;// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
////        user = userMapper.findByName(loginName);
//        if (user != null) {
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //用户的角色集合
//            info.addRoles(user.getRoleStrlist());
//            //用户的权限集合
//            info.addStringPermissions(user.getPerminsStrlist());
//
//            return info;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }


}