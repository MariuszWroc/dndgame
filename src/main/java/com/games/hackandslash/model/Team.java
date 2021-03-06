package com.games.hackandslash.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Team {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer money;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Set<Hero> heroes;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
