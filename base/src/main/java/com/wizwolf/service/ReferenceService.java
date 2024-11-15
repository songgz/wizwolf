package com.wizwolf.service;

import com.wizwolf.dao.ADReferenceRepository;
import com.wizwolf.entity.ADReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferenceService {
    private final ADReferenceRepository referenceRepo;

    @Autowired
    public ReferenceService(ADReferenceRepository referenceRepo) {
        this.referenceRepo = referenceRepo;
    }

    public Long getID (String referenceName) {
        Optional<ADReference> opt = this.referenceRepo.findByName(referenceName);
        return opt.map(ADReference::getId).orElse(Long.valueOf(0));
    }
}
