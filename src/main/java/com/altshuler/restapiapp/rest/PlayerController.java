package com.altshuler.restapiapp.rest;

import com.altshuler.restapiapp.model.Player;
import com.altshuler.restapiapp.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService PlayerService;

    @PostMapping(value = "/player")
    public ResponseEntity<?> add(@RequestBody Player Player) {
        PlayerService.saveOrUpdate(Player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/player")
    public ResponseEntity<List<Player>> get() {
        List<Player> fcList = PlayerService.getAll();
        if (fcList == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fcList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/player/{id}")
    public ResponseEntity<Player> getById(@PathVariable(name = "id") int id) {
        Player fc = PlayerService.getById(id);
        if (fc == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fc, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/player/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Player Player) {
        if (PlayerService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Player.setId(id);
            PlayerService.saveOrUpdate(Player);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/player/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = PlayerService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
