package com.wizwolf.service;

import com.wizwolf.dao.ADUserRepo;
import com.wizwolf.dao.ADRoleRepo;
import com.wizwolf.entity.ADClient;
import com.wizwolf.entity.ADRole;
import com.wizwolf.entity.ADUser;
import com.wizwolf.util.KeyNamePair;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthenService {
    private final ADUserRepo userRepo;
    private final ADRoleRepo roleRepo;
    private ADUser user = null;
    private boolean authenticated;

    @Autowired
    public AuthenService(ADUserRepo userRepo, ADRoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Transactional
    public Optional<ADUser> login(String name, String password) {
        Optional<ADUser> userOptional = userRepo.findByName(name);
        if (userOptional.isPresent()) {
            this.user = userOptional.get();
            if (user.getPassword().equals(password)) {
                Hibernate.initialize(this.user.getRoles());
                return Optional.of(this.user);
            }
        }
        return Optional.empty();
    }

    public boolean isAuthenticated() {
        if (!this.authenticated) {
            if (this.user.getRoles().size() > 0 && this.user.getClient() != null) {
                this.authenticated = true;
            }
        }
        return this.authenticated;
    }

    public List<KeyNamePair> getRoles() {
        ArrayList<KeyNamePair> roles = new ArrayList<>();
        this.user.getRoles().forEach(role -> {
            roles.add(new KeyNamePair(role.getId(), role.getName()));
        });
        return roles;
    }

    public List<KeyNamePair> getClients(KeyNamePair role) {
        return roleRepo.findById(role.getKey())
                .stream()
                .map(role1 -> new KeyNamePair(role1.getClient().getId(), role1.getClient().getName()))
                .collect(Collectors.toList());
    }
}
