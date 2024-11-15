package com.wizwolf.dao;

import com.wizwolf.entity.ADTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ADTableRepoTest {
    @Autowired
    private ADTableRepository tableRepo;

    @Test
    public void testSaveAndFindADTable() {
        ADTable table = new ADTable();
        table.setName("ad_user");

        ADTable savedTable = tableRepo.save(table);
        ADTable foundTable = tableRepo.findById(savedTable.getId()).orElse(null);

        assertThat(foundTable).isNotNull();
        assertThat(foundTable.getName()).isEqualTo("ad_user");
    }

}
