package com.altshuler.restapiapp.repository;

import com.altshuler.restapiapp.model.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballClubRepository extends JpaRepository <FootballClub, Integer> {
    @Query("from footballClub fc where fc.title = :title")
    List<FootballClub> getFootballClubsByTitle(@Param("title") String title);
}
