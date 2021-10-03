package com.altshuler.restapiapp.rest;

import com.altshuler.restapiapp.model.FootballClub;
import com.altshuler.restapiapp.service.FootballClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FootballClubController {

    private final FootballClubService footballClubService;

    @PostMapping(value = "/fc")
    public ResponseEntity<?> add(@RequestBody FootballClub footballClub) {
        footballClubService.saveOrUpdate(footballClub);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/fc")
    public ResponseEntity<List<FootballClub>> get() {
        List<FootballClub> fcList = footballClubService.getAll();
        if (fcList == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fcList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/fc/{id}")
    public ResponseEntity<FootballClub> getById(@PathVariable(name = "id") int id) {
        FootballClub fc = footballClubService.getById(id);
        if (fc == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fc, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/fc/title/{title}")
    public ResponseEntity<FootballClub> getByTitle(@PathVariable(name = "title") String title) {
        FootballClub fc = footballClubService.getByTitle(title).stream().findFirst().orElse(null);
        if (fc == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fc, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/fc/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody FootballClub footballClub) {
        if (footballClubService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            footballClub.setId(id);
            footballClubService.saveOrUpdate(footballClub);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/fc/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = footballClubService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
