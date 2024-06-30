package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guidejourney.model.entities.Role;
import com.guidejourney.repositories.RoleRepository;
import com.guidejourney.exceptions.RoleNotFoundException;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
