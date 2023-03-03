package com.hacheery.reservation.repository;

import com.hacheery.reservation.constant.ERole;
import com.hacheery.reservation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by HachNV on Mar 02, 2023
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
