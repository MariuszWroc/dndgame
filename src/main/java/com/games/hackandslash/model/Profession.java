package com.games.hackandslash.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Profession {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    @OneToMany(mappedBy = "profession", fetch = FetchType.LAZY)
    private List<Hero> heroes;
}
