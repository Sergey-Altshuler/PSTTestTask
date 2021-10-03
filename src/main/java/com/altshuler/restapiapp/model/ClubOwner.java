package com.altshuler.restapiapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "owner")
@Table(name = "owners")
public class ClubOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private byte age;
    @Column
    private String nationality;
    @OneToOne
    @JoinColumn(name="fc_id")
    private FootballClub footballClub;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubOwner clubOwner = (ClubOwner) o;
        return Objects.equals(id, clubOwner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClubOwner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
