package com.altshuler.restapiapp.service;

import com.altshuler.restapiapp.model.FootballClub;

import java.util.List;

public interface FootballClubService {
    FootballClub saveOrUpdate(FootballClub footballClub);
    FootballClub getById (Integer id);
    List<FootballClub> getAll();
    boolean deleteById (Integer id);
    List<FootballClub> getByTitle(String title);
}
