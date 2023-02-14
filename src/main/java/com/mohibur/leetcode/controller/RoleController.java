package com.mohibur.leetcode.controller;

import com.mohibur.leetcode.entity.Role;
import com.mohibur.leetcode.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
