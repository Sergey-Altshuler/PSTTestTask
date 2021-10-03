package com.altshuler.restapiapp.service.impl;

import com.altshuler.restapiapp.model.Player;
import com.altshuler.restapiapp.repository.PlayerRepository;
import com.altshuler.restapiapp.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    @Override
    public Player saveOrUpdate(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getById(Integer id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        } else return false;
    }
}
