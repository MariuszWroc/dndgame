package com.games.hackandslash.model;

import lombok.*;

import javax.persistence.*;

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
//    @Fetch(FetchMode.SELECT)
//    @OneToMany(mappedBy = "profession", fetch = FetchType.LAZY)
//    private List<Hero> heroes;
}
