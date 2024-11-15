package com.wizwolf.dao;

import com.wizwolf.entity.ADReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ADReferenceRepository extends JpaRepository<ADReference, Long>, JpaSpecificationExecutor<ADReference> {
    Optional<ADReference> findByName(String referenceName);
}
