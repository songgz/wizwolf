package com.wizwolf.service;

import com.wizwolf.dao.ADRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final ADRoleRepository roleRepo;

    @Autowired
    public RoleService(ADRoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }
}
