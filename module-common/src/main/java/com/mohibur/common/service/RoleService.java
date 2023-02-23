package com.mohibur.common.service;

import com.mohibur.common.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface RoleService {
    ResponseEntity<Role> createRole(Role role);

    ResponseEntity<Role> getRoleById(Long id);

    ResponseEntity<List<Role>> getAllRoles();

    ResponseEntity<Role> updateRole(Role role);

    ResponseEntity<?> deleteRole(Long id);
}
