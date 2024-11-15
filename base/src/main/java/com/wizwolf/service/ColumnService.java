package com.wizwolf.service;

import com.wizwolf.dao.ADColumnRepository;
import com.wizwolf.entity.ADReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColumnService {
    private final ADColumnRepository columnRepo;

    @Autowired
    public ColumnService(ADColumnRepository columnRepo) {
        this.columnRepo = columnRepo;
    }

    public Long getID(String columnName) {
        Optional<ADReference> opt = this.columnRepo.findByName(columnName);
        return opt.map(ADReference::getId).orElse(Long.valueOf(0));
    }
}
