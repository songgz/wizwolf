package com.wizwolf.service;

import com.wizwolf.dao.ADUserRepository;
import com.wizwolf.dao.ADRoleRepository;
import com.wizwolf.entity.ADUser;
import com.wizwolf.util.KeyNamePair1;
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
    private final ADUserRepository userRepo;
    private final ADRoleRepository roleRepo;
    private ADUser user = null;
    private boolean authenticated;

    @Autowired
    public AuthenService(ADUserRepository userRepo, ADRoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Transactional
    public Optional<ADUser> login(String name, String password) {
        Optional<ADUser> userOptional = userRepo.findByName(name);
        if (userOptional.isPresent()) {
            this.user = userOptional.get();
            if (user.getPassword().equals(password) && user.getClient().getIsActive()) {
                Hibernate.initialize(this.user.getRoles());
                return Optional.of(this.user);
            }
        }
        return Optional.empty();
    }

    public boolean isAuthenticated() {
        if (!this.authenticated) {
            if (!this.user.getRoles().isEmpty() && this.user.getClient().getIsActive()) {
                this.authenticated = true;
            }
        }
        return this.authenticated;
    }

    public List<KeyNamePair1> getRoles() {
        ArrayList<KeyNamePair1> roles = new ArrayList<>();
        this.user.getRoles().forEach(role -> {
            roles.add(new KeyNamePair1(role.getId(), role.getName()));
        });
        return roles;
    }

    public List<KeyNamePair1> getClients(KeyNamePair1 role) {
        return roleRepo.findById(role.getKey())
                .stream()
                .map(role1 -> new KeyNamePair1(role1.getClient().getId(), role1.getClient().getName()))
                .collect(Collectors.toList());
    }
}
