package com.altshuler.restapiapp.repository;

import com.altshuler.restapiapp.model.ClubOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubOwnerRepository extends JpaRepository<ClubOwner, Integer> {
}
