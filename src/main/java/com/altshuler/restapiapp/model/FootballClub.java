package com.altshuler.restapiapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "footballClub")
@Table(name = "footballClubs")
public class FootballClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String title;
    @Column
    private int budget;
    @Column
    private String league;
    @OneToMany(mappedBy = "footballClub", fetch = FetchType.EAGER)
    private List<Player> team = new ArrayList<>();
    @OneToOne(mappedBy = "footballClub")
    private ClubOwner clubOwner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", budget=" + budget +
                ", league='" + league + '\'' +
                '}';
    }
}
