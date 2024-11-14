package com.wizwolf.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@MappedSuperclass
@EqualsAndHashCode(exclude = {"client", "org"})
@ToString(exclude = {"client", "org"})
public abstract class BaseEntity {
    private Character isactive;
    private LocalDateTime created;
    private BigInteger createdby;
    private LocalDateTime updated;
    private BigInteger updatedby;
    private String description;
    private String help;

    @ManyToOne
    @JoinColumn(name = "ad_client_id")
    private ADClient client;

    @ManyToOne
    @JoinColumn(name = "ad_org_id")
    private ADOrg org;


}
