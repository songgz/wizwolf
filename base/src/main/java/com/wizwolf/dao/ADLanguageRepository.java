package com.wizwolf.dao;

import com.wizwolf.entity.ADLanguage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ADLanguageRepository extends JpaRepository<ADLanguage, Long>, JpaSpecificationExecutor<ADLanguage> {

    @Query("SELECT l FROM ADLanguage l WHERE l.issystemlanguage = 'Y' AND l.isactive='Y' Order BY l.name asc")
    List<ADLanguage> getSystemLanguage();

    //findAll(Sort.by(Sort.Order.asc("name")));
    List<ADLanguage> findAll(Sort sort);
}
