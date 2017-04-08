package cn.v5cn.v5cms.shiro;

import cn.v5cn.v5cms.service.SystemUserService;
import cn.v5cn.v5cms.entity.SystemUser;
import cn.v5cn.v5cms.util.SystemConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
public class V5CMSRealm extends AuthorizingRealm {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 设置权限
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录验证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = authenticationToken.getPrincipal().toString();
        SystemUser systemUser = systemUserService.findByLoginname(loginName);
        if(systemUser == null){
            throw new UnknownAccountException();
        }
        if(systemUser.getAvailable() == 2){
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                systemUser.getLoginname(),
                systemUser.getPassword(),
                ByteSource.Util.bytes(PasswordHelper.getCredentialsSalt(systemUser.getLoginname(),systemUser.getSalt())),
                getName()
        );
        systemUser.setPassword("");
        systemUser.setSalt("");
        SecurityUtils.getSubject().getSession().setAttribute(SystemConstant.SESSION_KEY,systemUser);
        return authenticationInfo;

    }
}
