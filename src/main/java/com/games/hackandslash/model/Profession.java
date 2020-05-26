package com.games.hackandslash.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Profession {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "profession", fetch = FetchType.LAZY)
    private List<Hero> heroes;
}
