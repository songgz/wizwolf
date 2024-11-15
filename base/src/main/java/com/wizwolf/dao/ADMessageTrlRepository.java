package com.wizwolf.dao;

import com.wizwolf.entity.ADMessageTrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ADMessageTrlRepository extends JpaRepository<ADMessageTrl, Long>, JpaSpecificationExecutor<ADMessageTrl> {
    List<ADMessageTrl> findByLanguage(String language);
}
