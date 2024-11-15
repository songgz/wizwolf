package com.wizwolf.dao;


import com.wizwolf.entity.ADUser;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ADUserRepoTest {

    @Autowired
    private ADUserRepository userRepo;

    @Test
    public void findByIdTest() {
        ADUser user = new ADUser();
        ADUser saveUser = userRepo.save(user);

        ADUser foundUser =  userRepo.findById(saveUser.getId()).orElse(null);
        assertThat(foundUser).isNotNull();
    }

    @Test
    public void test2() {
        System.out.println("adf");
    }
}
