package com.company.sample.user;

import io.jmix.oidc.user.DefaultJmixOidcUser;

public class MyJmixOidcUser extends DefaultJmixOidcUser {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
