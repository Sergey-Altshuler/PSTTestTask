package com.altshuler.restapiapp.service;

import com.altshuler.restapiapp.model.Player;

import java.util.List;

public interface PlayerService {
    Player saveOrUpdate(Player player);
    Player getById (Integer id);
    List<Player> getAll();
    boolean deleteById (Integer id);
}
