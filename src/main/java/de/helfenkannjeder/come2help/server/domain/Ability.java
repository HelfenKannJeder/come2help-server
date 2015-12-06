package de.helfenkannjeder.come2help.server.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ability extends AbstractVersionedAuditable {

    @Id
    @GeneratedValue
    private Long id = null;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "abilities")
    private List<Volunteer> volunteers = Collections.emptyList();

    @ManyToOne
    @JoinColumn(name = "ABILITY_CATEGORY_ID")
    private AbilityCategory abilityCategory;

    public Ability() {
    }

    public Ability(Long id, String name, String description, AbilityCategory abilityCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.abilityCategory = abilityCategory;
    }

    public void update(Ability ability) {
        this.name = ability.name;
        this.description = ability.description;
        this.abilityCategory = ability.abilityCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public AbilityCategory getAbilityCategory() {
        return abilityCategory;
    }

    public void setAbilityCategory(AbilityCategory abilityCategory) {
        this.abilityCategory = abilityCategory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        hash = 31 * hash + Objects.hashCode(this.volunteers);
        hash = 31 * hash + Objects.hashCode(this.abilityCategory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ability other = (Ability) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.volunteers, other.volunteers)) {
            return false;
        }
        if (!Objects.equals(this.abilityCategory, other.abilityCategory)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ability{" + "id=" + id + ", name=" + name + ", description=" + description + ", volunteers=" + volunteers + ", abilityCategory=" + abilityCategory + '}';
    }

}
