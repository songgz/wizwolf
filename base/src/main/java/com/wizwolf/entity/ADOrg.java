package com.wizwolf.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ad_org")
@Where(clause="isactive='Y'")
public class ADOrg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_org_id")
    private Long id;
    private String name;
    @Column(name = "`value`")
    private String value;

    private Character isactive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String description;
    //private String help;

}