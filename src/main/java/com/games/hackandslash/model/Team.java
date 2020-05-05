package com.games.hackandslash.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer money;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Hero> heroes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_id")
    private User user;
}
