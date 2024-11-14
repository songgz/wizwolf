package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ad_reference")
public class ADReference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_reference_id")
    private Long id;
    private String name;
    private String validationtype;

    private Character isactive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String description;

}
