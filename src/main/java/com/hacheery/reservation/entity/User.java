package com.hacheery.reservation.entity;

import com.hacheery.reservation.constant.EGender;
import com.hacheery.reservation.model.BaseTimeStamp;
import com.hacheery.reservation.constant.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by HachNV on Mar 02, 2023
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeStamp implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String phone;

    //@Enumerated(EnumType.ORDINAL)
    private String gender;

    private String dob;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean enabled;

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}