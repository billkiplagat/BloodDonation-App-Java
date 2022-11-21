package com.billy.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public enum ApplicationUserRole {
    ADMIN,
    DONOR;

    private final String role;
    ApplicationUserRole() {
        this.role = this.name();
    }

    public Collection<? extends GrantedAuthority> getAuthority() {
        return Sets.newHashSet(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
