package com.altshuler.restapiapp.service.impl;

import com.altshuler.restapiapp.model.FootballClub;
import com.altshuler.restapiapp.repository.FootballClubRepository;
import com.altshuler.restapiapp.service.FootballClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballClubServiceImpl implements FootballClubService {

    private final FootballClubRepository footballClubRepository;

    @Override
    public FootballClub saveOrUpdate(FootballClub footballClub) {
        return footballClubRepository.save(footballClub);
    }

    @Override
    public FootballClub getById(Integer id) {
        return footballClubRepository.findById(id).orElse(null);
    }

    @Override
    public List<FootballClub> getAll() {
        return footballClubRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        if (footballClubRepository.existsById(id)) {
            footballClubRepository.deleteById(id);
            return true;
        } else return false;


    }

    @Override
    public List<FootballClub> getByTitle(String title) {
        return footballClubRepository.getFootballClubsByTitle(title);
    }
}
