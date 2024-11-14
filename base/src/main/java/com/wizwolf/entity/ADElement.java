package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad_element")
@Inheritance(strategy = InheritanceType.JOINED)
public class ADElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_element_id")
    private Long id;
}
