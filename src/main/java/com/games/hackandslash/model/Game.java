package com.games.hackandslash.model;

import com.games.hackandslash.common.GameStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Game {
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_owner_id", referencedColumnName = "id")
    private User owner;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_fellow_id", referencedColumnName = "id")
    private User fellow;
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;
}
