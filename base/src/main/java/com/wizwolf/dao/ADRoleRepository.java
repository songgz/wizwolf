package com.wizwolf.dao;

import com.wizwolf.entity.ADRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ADRoleRepository extends JpaRepository<ADRole, Long>, JpaSpecificationExecutor<ADRole> {
}
