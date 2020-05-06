package com.games.hackandslash.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

/**
 *
 * @author mariusz
 */
@Entity
@Data
public class Role {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String rolename;
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList;
}
