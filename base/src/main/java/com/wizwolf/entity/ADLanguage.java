package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Locale;

@Data
@Entity
@Table(name = "ad_language")
public class ADLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_language_id")
    private Long id;

    private String issystemlanguage;
    private String isactive;
    private String name;
    private String languageiso;
    private String countrycode;
    private String isbaselanguage;
    private String ad_language;

    public Locale getLocale() {
        return new Locale("en", "AU");
    }
}
