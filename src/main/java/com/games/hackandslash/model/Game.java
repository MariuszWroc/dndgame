package com.games.hackandslash.model;

import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Game {
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_team_mapping", 
      joinColumns = {@JoinColumn(name = "Game_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "Team_id", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "User_id")
    private Map<User, Team> userToTeamMap;
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;
}
