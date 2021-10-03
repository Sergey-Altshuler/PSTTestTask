package com.altshuler.restapiapp.service;

import com.altshuler.restapiapp.model.ClubOwner;

import java.util.List;

public interface ClubOwnerService {
    ClubOwner saveOrUpdate(ClubOwner ClubOwner);
    ClubOwner getById (Integer id);
    List<ClubOwner> getAll();
    boolean deleteById (Integer id);
}
