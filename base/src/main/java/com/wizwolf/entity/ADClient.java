package com.wizwolf.entity;

import com.wizwolf.converter.BooleanToCharConverter;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ad_client")
@Where(clause="isactive='Y'")
public class ADClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_client_id")
    private Long id;
    private String name;

    @Convert(converter = BooleanToCharConverter.class)
    @Column(name = "isactive")
    private Boolean isActive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String description;
    //private String help;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ADRole> roles = new HashSet<>();;



}
