package com.games.hackandslash.model;

import com.games.hackandslash.common.Gender;
import com.games.hackandslash.common.Race;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariusz
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Hero {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer speed;
    @Size(max = 45)
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Race race;
    @JoinColumn(name = "profession_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
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
    @JoinTable(name = "equipment",
            joinColumns = @JoinColumn(name = "hero_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false, updatable = false))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Item> items = new ArrayList<>();
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team team;
}
