package com.company.sample.security;

import com.company.sample.entity.Author;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "AuthorsAdmin", code = "authors-admin")
public interface AuthorsAdminRole {
    @MenuPolicy(menuIds = "Author.browse")
    @ScreenPolicy(screenIds = {"Author.browse", "Author.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = Author.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Author.class, actions = EntityPolicyAction.ALL)
    void author();
}