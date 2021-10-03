package com.altshuler.restapiapp.service.impl;

import com.altshuler.restapiapp.model.ClubOwner;
import com.altshuler.restapiapp.repository.ClubOwnerRepository;
import com.altshuler.restapiapp.service.ClubOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubOwnerServiceImpl implements ClubOwnerService {
    private final ClubOwnerRepository ClubOwnerRepository;

    @Override
    public ClubOwner saveOrUpdate(ClubOwner ClubOwner) {
        return ClubOwnerRepository.save(ClubOwner);
    }

    @Override
    public ClubOwner getById(Integer id) {
        return ClubOwnerRepository.findById(id).orElse(null);
    }

    @Override
    public List<ClubOwner> getAll() {
        return ClubOwnerRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        if (ClubOwnerRepository.existsById(id)) {
            ClubOwnerRepository.deleteById(id);
            return true;
        } else return false;


    }
}
