package com.wizwolf.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ad_table")
@EqualsAndHashCode(exclude = {"client", "org"})
@ToString(exclude = {"client", "org"})
public class ADTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_table_id")
    private Long id;

    private String name;
    private String tablename;

    private Character isview;
    private Character isactive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String help;

    @ManyToOne
    @JoinColumn(name = "ad_client_id")
    private ADClient client;

    @ManyToOne
    @JoinColumn(name = "ad_org_id")
    private ADOrg org;





}
