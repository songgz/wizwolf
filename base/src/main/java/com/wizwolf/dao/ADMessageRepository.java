package com.wizwolf.dao;

import com.wizwolf.entity.ADMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ADMessageRepository extends JpaRepository<ADMessage, Long>, JpaSpecificationExecutor<ADMessage> {
}
