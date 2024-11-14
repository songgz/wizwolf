package com.wizwolf.service;

import com.wizwolf.dao.ADRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final ADRoleRepo roleRepo;

    @Autowired
    public RoleService(ADRoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }
}
