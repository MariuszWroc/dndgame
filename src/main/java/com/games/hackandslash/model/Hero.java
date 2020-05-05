package com.games.hackandslash.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 *
 * @author mariusz
 */
@Entity
@Data
public class Hero {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer speed;
    @Size(max = 45)
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer gender;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer race;
    @JoinColumn(name = "Profession_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profession profession;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer baseHP;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer currentHP;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer baseAC;
    @JoinColumn(name = "Equipment_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Equipment equipment;
    @JoinColumn(name = "Team_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team team;
}
