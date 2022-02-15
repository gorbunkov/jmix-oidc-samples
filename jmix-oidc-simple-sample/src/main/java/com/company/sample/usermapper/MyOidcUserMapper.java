package com.company.sample.usermapper;

import com.company.sample.user.MyJmixOidcUser;
import io.jmix.oidc.claimsmapper.ClaimsRolesMapper;
import io.jmix.oidc.usermapper.BaseOidcUserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyOidcUserMapper extends BaseOidcUserMapper<MyJmixOidcUser> {

    private ClaimsRolesMapper claimsRolesMapper;

    public MyOidcUserMapper(ClaimsRolesMapper claimsRolesMapper) {
        this.claimsRolesMapper = claimsRolesMapper;
    }

    @Override
    protected MyJmixOidcUser initJmixUser(OidcUser oidcUser) {
        return new MyJmixOidcUser();
    }

    @Override
    protected void populateUserAttributes(OidcUser oidcUser, MyJmixOidcUser myJmixOidcUser) {
        myJmixOidcUser.setPosition((String) oidcUser.getClaims().get("position"));
    }

    @Override
    protected void populateUserAuthorities(OidcUser oidcUser, MyJmixOidcUser jmixUser) {
        Collection<? extends GrantedAuthority> authorities = claimsRolesMapper.toGrantedAuthorities(oidcUser.getClaims());
        jmixUser.setAuthorities(authorities);
    }
}
