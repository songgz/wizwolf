package com.wizwolf.service;

import com.wizwolf.dao.ADTableRepository;
import com.wizwolf.entity.ADTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService {
    private final ADTableRepository tableRepo;

    @Autowired
    public TableService(ADTableRepository tableRepo) {
        this.tableRepo = tableRepo;
    }

    public String getTableName(Long id) {
        Optional<ADTable> obj = tableRepo.findById(id);
        return obj.map(ADTable::getName).orElse("");
    }
}
