package com.wizwolf.dao;

import com.wizwolf.entity.ADTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ADTableRepository extends JpaRepository<ADTable, Long>, JpaSpecificationExecutor<ADTable> {

}
