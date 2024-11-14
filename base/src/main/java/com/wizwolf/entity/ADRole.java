package com.wizwolf.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Where(clause="isactive='Y'")
@Table(name = "ad_role")
@EqualsAndHashCode(exclude = {"client", "org"})
@ToString(exclude = {"client","org"})
public class ADRole {
    public static final String TABLE_NAME = "ad_role";

    public static int getTable_ID() {
        //Optional<User> u = UserDAO.findUserByLoginName(TABLE_NAME);
        return 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_role_id")
    private Long id;
    private String name;

    private Character isactive;
    private LocalDateTime created;
    private Long createdby;
    private LocalDateTime updated;
    private Long updatedby;
    private String description;

    @ManyToOne
    @JoinColumn(name = "ad_client_id")
    private ADClient client;

    @ManyToOne
    @JoinColumn(name = "ad_org_id")
    private ADOrg org;

}
