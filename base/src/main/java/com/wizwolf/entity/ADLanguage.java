package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad_language")
public class ADLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_element_id")
    private Long id;

    private String issystemlanguage;
    private String isactive;
    private String name;
}
