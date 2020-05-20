package com.games.hackandslash.model;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Game {
	@Id
	@Basic(optional = false)
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
