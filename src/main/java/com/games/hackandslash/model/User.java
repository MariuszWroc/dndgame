package com.games.hackandslash.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author mariusz
 */
@Entity
@Data
@Builder
public class User {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 45)
    private String firstname;
    @Size(max = 45)
    private String lastname;
    @NotBlank
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    @Size(min = 3, max = 45)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    @Email
    @NotBlank
    private String email;
    @Basic(optional = false)
    @Column(nullable = false)
    private Boolean activated;
    @Enumerated(EnumType.STRING)
    private RoleName role;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
