package com.company.sample.rolesmapper;

import com.company.sample.security.AuthorsAdminRole;
import com.company.sample.security.BooksAdminRole;
import com.company.sample.security.FullAccessRole;
import io.jmix.oidc.claimsmapper.BaseClaimsRolesMapper;
import io.jmix.security.role.ResourceRoleRepository;
import io.jmix.security.role.RowLevelRoleRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@Component
public class MyClaimsRoleMapper extends BaseClaimsRolesMapper {

    public MyClaimsRoleMapper(ResourceRoleRepository resourceRoleRepository,
                              RowLevelRoleRepository rowLevelRoleRepository) {
        super(resourceRoleRepository, rowLevelRoleRepository);
    }

    @Override
    protected Collection<String> getResourceRolesCodes(Map<String, Object> claims) {
        Collection<String> jmixRoleCodes = new HashSet<>();
        String position = (String) claims.get("position");
        if ("Manager".equals(position)) {
            jmixRoleCodes.add(FullAccessRole.CODE);
        } else {
            jmixRoleCodes.add(AuthorsAdminRole.CODE);
            jmixRoleCodes.add(BooksAdminRole.CODE);
        }
        return jmixRoleCodes;
    }
}
