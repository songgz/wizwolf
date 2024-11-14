package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad_message")
@Inheritance(strategy = InheritanceType.JOINED)
public class ADMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_message_id")
    private Long id;

    @Column(name = "`value`")
    private String value;
    private String msgtext;
    private String msgtip;


}
