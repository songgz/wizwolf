package com.wizwolf.dao;

import com.wizwolf.entity.ADUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ADUserRepo extends JpaRepository<ADUser, Long>, JpaSpecificationExecutor<ADUser> {

    @Query(nativeQuery = true, value ="SELECT * FROM ad_user WHERE isactive='Y' name=?1 ")
    Optional<ADUser> findUserByLoginName(String name);

    @Query("SELECT u FROM ADUser u")
    List<ADUser> findAll();

    Optional<ADUser> findByName(String userName);
}
