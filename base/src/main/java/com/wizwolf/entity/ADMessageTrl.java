package com.wizwolf.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ad_message_trl")
public class ADMessageTrl extends ADElement {

    @Column(name = "ad_language")
    private String language;

    private String msgtext;
    private String msgtip;



    @ManyToOne
    @JoinColumn(name = "ad_message_id")
    private ADMessage message;
}
