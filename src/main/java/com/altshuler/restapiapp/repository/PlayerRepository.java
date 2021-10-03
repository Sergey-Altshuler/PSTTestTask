package com.altshuler.restapiapp.repository;

import com.altshuler.restapiapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
