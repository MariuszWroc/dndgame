package com.games.hackandslash.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 *
 * @author mariusz
 */
@Entity
@Data
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
    @JoinColumn(name = "Role_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
