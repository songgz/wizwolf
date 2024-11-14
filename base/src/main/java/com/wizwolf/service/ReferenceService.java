package com.wizwolf.service;

import com.wizwolf.dao.ADReferenceRepo;
import com.wizwolf.entity.ADReference;
import com.wizwolf.entity.ADTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferenceService {
    private final ADReferenceRepo referenceRepo;

    @Autowired
    public ReferenceService(ADReferenceRepo referenceRepo) {
        this.referenceRepo = referenceRepo;
    }

    public Long getID (String referenceName) {
        Optional<ADReference> opt = this.referenceRepo.findByName(referenceName);
        return opt.map(ADReference::getId).orElse(Long.valueOf(0));
    }
}
