package com.wizwolf.entity;

import com.wizwolf.converter.BooleanToCharConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ad_user")
@EqualsAndHashCode(exclude = {"client", "org"})
@ToString(exclude = {"client","org"})
@Where(clause="isactive='Y'")
public class ADUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_user_id")
    private Long id;
    private String name;
    private String password;
    private String salt;

    @Convert(converter = BooleanToCharConverter.class)
    @Column(name = "isactive")
    private Boolean isActive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String description;
    //private String help;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "ad_user_roles",joinColumns = @JoinColumn(name = "ad_user_id"), inverseJoinColumns = @JoinColumn(name = "ad_role_id"))
    //@Where(clause = "isactive = 'Y'")
    private Set<ADRole> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ad_client_id")
    private ADClient client;

    @ManyToOne
    @JoinColumn(name = "ad_org_id")
    private ADOrg org;

}
