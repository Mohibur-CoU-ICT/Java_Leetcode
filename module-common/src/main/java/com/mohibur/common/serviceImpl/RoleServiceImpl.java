package com.mohibur.common.serviceImpl;

import com.mohibur.common.entity.Role;
import com.mohibur.common.repository.RoleRepository;
import com.mohibur.common.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<Role> createRole(Role role) {
        Role role1 = roleRepository.save(role);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(role1, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Role> getRoleById(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            return new ResponseEntity<>(role, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(roles, httpHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Role> updateRole(Role role) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Optional<Role> optionalRole = roleRepository.findById(role.getId());
        if (optionalRole.isPresent()) {
            Role role1 = optionalRole.get();
            BeanUtils.copyProperties(role, role1);
            roleRepository.save(role1);
            return new ResponseEntity<>(role1, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteRole(Long id) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No role found with id " + id, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Role deleted successfully.", httpHeaders, HttpStatus.OK);
    }
}
