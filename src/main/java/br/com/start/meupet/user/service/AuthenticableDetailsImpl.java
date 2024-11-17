package br.com.start.meupet.user.service;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.start.meupet.common.interfaces.Authenticable;

@Getter
public class UserDetailsImpl implements UserDetails {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID id;

    private final String name;

    private final String email;

    private final String password;

    private final String phoneNumber;
    
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Authenticable user) {
        return new UserDetailsImpl(user.getId(), user.getName(), user.getEmail().toString(), user.getPassword(), user.getPhoneNumber().toString(), new ArrayList<>());
    }

    public UserDetailsImpl(UUID id, String name, String email, String password, String phoneNumber, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}