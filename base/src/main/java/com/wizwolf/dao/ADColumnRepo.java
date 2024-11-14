package com.wizwolf.dao;

import com.wizwolf.entity.ADColumn;
import com.wizwolf.entity.ADReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ADColumnRepo extends JpaRepository<ADColumn, Long>, JpaSpecificationExecutor<ADColumn> {
    Optional<ADReference> findByName(String columnName);
}
