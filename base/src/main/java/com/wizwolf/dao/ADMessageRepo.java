package com.wizwolf.dao;

import com.wizwolf.entity.ADMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ADMessageRepo extends JpaRepository<ADMessage, Long>, JpaSpecificationExecutor<ADMessage> {
}
