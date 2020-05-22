package com.games.hackandslash.model;

import com.games.hackandslash.common.Category;
import lombok.*;

import javax.persistence.*;
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
public class Item {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer attack;
    private Integer defend;
    private Integer magic;
    private Integer addHealth;
    private Integer addStrength;
    private Integer addDexterity;
    private Integer addConstitution;
    private Integer addIntelligence;
    private Integer amount;
    @ManyToMany(mappedBy = "items")
    private List<Equipment> equipments = new ArrayList<>();
}
