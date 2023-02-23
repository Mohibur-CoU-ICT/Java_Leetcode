package com.mohibur.security.controller;

import com.mohibur.security.entity.Role;
import com.mohibur.common.interfaces.UrlConstant;
import com.mohibur.security.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.RoleUrl.ROOT)
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping(UrlConstant.ID)
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @DeleteMapping(UrlConstant.ID)
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
