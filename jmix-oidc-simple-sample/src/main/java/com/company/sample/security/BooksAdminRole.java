package com.company.sample.security;

import com.company.sample.entity.Book;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "BookAdmin", code = BooksAdminRole.CODE)
public interface BooksAdminRole {

    String CODE = "books-admin";

    @MenuPolicy(menuIds = "Book.browse")
    @ScreenPolicy(screenIds = {"Book.browse", "Book.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = Book.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Book.class, actions = EntityPolicyAction.ALL)
    void book();
}