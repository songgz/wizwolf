package com.wizwolf.service;

import com.wizwolf.dao.ADUserRepo;
import com.wizwolf.entity.ADUser;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final ADUserRepo userRepo;

    @Autowired
    public UserService(ADUserRepo userRepo) {
        this.userRepo = userRepo;
    }


    //public Optional<ADUser> login(String userName, String userPassword) {
        //Optional<ADUser> o = userRepo.findOne((root, query, cb) -> cb.and(cb.equal(root.get("name"), userName)));
        //return o.filter(user -> user.getPassword().equals(userPassword));


//        o.ifPresent(user -> {
//            user.getRoles().forEach(role -> {
//                System.out.println(role.getName());
//            });
//            result.set(user.getPassword().equals(userPassword));
//        });
//        return result.get();
    //}

    @Transactional
    public Optional<ADUser> login(String name, String password) {
        Optional<ADUser> userOptional = userRepo.findByName(name);
        if (userOptional.isPresent()) {
            ADUser user = userOptional.get();
            if (user.getPassword().equals(password)) {
                Hibernate.initialize(user.getRoles());
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


}
