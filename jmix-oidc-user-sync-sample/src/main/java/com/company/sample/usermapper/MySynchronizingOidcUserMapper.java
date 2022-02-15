package com.company.sample.usermapper;

import com.company.sample.entity.User;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.UserRepository;
import io.jmix.oidc.claimsmapper.ClaimsRolesMapper;
import io.jmix.oidc.usermapper.SynchronizingOidcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
public class MySynchronizingOidcUserMapper extends SynchronizingOidcUserMapper<User> {

    @Autowired
    public MySynchronizingOidcUserMapper(UnconstrainedDataManager dataManager,
                                         UserRepository userRepository,
                                         ClaimsRolesMapper claimsRolesMapper) {
        super(dataManager, userRepository, claimsRolesMapper);

        //store role assignments in the database (false by default)
        setSynchronizeRoleAssignments(true);
    }

    @Override
    protected Class<User> getApplicationUserClass() {
        return User.class;
    }

    @Override
    protected void populateUserAttributes(OidcUser oidcUser, User jmixUser) {
        jmixUser.setUsername(getOidcUserUsername(oidcUser));
        jmixUser.setFirstName(oidcUser.getGivenName());
        jmixUser.setLastName(oidcUser.getFamilyName());
        jmixUser.setEmail(oidcUser.getEmail());
    }
}
