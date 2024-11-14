package com.wizwolf.model;

import com.wizwolf.dao.ADTableRepo;
import com.wizwolf.entity.ADTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MQueryFactory {
    private final ADTableRepo tableRepo;

    @Autowired
    public MQueryFactory(ADTableRepo tableRepo) {
        this.tableRepo = tableRepo;
    }

    public MQuery createMQuery() {
        return new MQuery();
    }

    public MQuery createMQuery(String tableName) {
        return new MQuery(tableName);
    }

    public MQuery createMQuery(Long ad_table_id) {
        Optional<ADTable> o = this.tableRepo.findById(ad_table_id);
        if (o.isPresent()) {
            return new MQuery(o.get().getName());
        }else{
            return new MQuery();
        }
    }
}
