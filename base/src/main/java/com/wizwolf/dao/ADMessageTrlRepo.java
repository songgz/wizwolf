package com.wizwolf.dao;

import com.wizwolf.entity.ADMessageTrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ADMessageTrlRepo extends JpaRepository<ADMessageTrl, Long>, JpaSpecificationExecutor<ADMessageTrl> {
    List<ADMessageTrl> findByLanguage(String language);
}
