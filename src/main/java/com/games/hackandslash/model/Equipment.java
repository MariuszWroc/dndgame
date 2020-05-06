/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.games.hackandslash.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author mariusz
 */
@Entity
@Data
@Builder
public class Equipment {
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "equipment", fetch = FetchType.LAZY)
	private Hero hero;
	@JoinTable(name = "equipment_item", joinColumns = @JoinColumn(name = "Equipment_id", referencedColumnName = "id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "Item_id", referencedColumnName = "id", nullable = false, updatable = false))
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Item> items = new ArrayList<>();
}
