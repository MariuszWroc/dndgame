/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.games.hackandslash.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
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
public class Equipment {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "equipment", fetch = FetchType.LAZY)
    private Hero hero;
    @JoinTable(name = "equipment_item",
            joinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false, updatable = false))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Item> items = new ArrayList<>();
}
