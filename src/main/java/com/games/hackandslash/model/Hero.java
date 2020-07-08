package com.games.hackandslash.model;

import com.games.hackandslash.common.Gender;
import com.games.hackandslash.common.Race;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.games.hackandslash.common.Category.*;

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
    @Basic(optional = false)
    @Column(nullable = false)
    @JoinTable(name = "equipment",
            joinColumns = @JoinColumn(name = "hero_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false, updatable = false))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Item> items = new ArrayList<>();
    @Transient
    private int additionalAttackPoints;
    @Transient
    private int additionalDefendPoints;


    public int countAttack() {
        int weaponPoints = 0;
        Optional<Item> optionalWeapon = items.stream().filter(x -> x.getCategory().equals(WEAPON)).findFirst();
        if (optionalWeapon.isPresent()) {
            optionalWeapon.get().getAttack();
        }

        int strengthPoints = getProfession().getStrength();
        return strengthPoints + weaponPoints + additionalAttackPoints;
    }

    public int countDefend() {
        int armor = 0;
        int shield = 0;
        Optional<Item> optionalArmor = items.stream().filter(x -> x.getCategory().equals(ARMOR)).findFirst();
        Optional<Item> optionalShield = items.stream().filter(x -> x.getCategory().equals(SHIELD)).findFirst();

        if (optionalArmor.isPresent()) {
            armor = optionalArmor.get().getDefend();
        }

        if (optionalArmor.isPresent()) {
            shield = optionalShield.get().getDefend();
        }

        return getBaseAC() + armor + shield + additionalDefendPoints;
    }

    public void updateHealth(Integer attackerPoints) {
        int damagePoints = attackerPoints - countDefend();
        if ((currentHP > 0) && (damagePoints > 0)) {
            currentHP = currentHP + damagePoints;
        }
    }

    public void useItem(Item item) {
        switch (item.getCategory()) {
            case SPELL_HEALTH:
                currentHP = currentHP + item.getHealth();
                break;
            case POTION:
                currentHP = currentHP + item.getHealth();
                break;
            case SPELL_DEFEND:
                additionalDefendPoints = item.getDefend();
                break;
            case SPELL_ATTACK:
                additionalAttackPoints = item.getAttack();
                break;
        }
    }
}
