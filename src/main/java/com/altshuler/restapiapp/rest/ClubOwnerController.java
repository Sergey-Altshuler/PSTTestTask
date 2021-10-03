package com.altshuler.restapiapp.rest;

import com.altshuler.restapiapp.model.ClubOwner;
import com.altshuler.restapiapp.service.ClubOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClubOwnerController {
    private final ClubOwnerService ClubOwnerService;

    @PostMapping(value = "/owner")
    public ResponseEntity<?> add(@RequestBody ClubOwner ClubOwner) {
        ClubOwnerService.saveOrUpdate(ClubOwner);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/owner")
    public ResponseEntity<List<ClubOwner>> get() {
        List<ClubOwner> fcList = ClubOwnerService.getAll();
        if (fcList == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fcList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/owner/{id}")
    public ResponseEntity<ClubOwner> getById(@PathVariable(name = "id") int id) {
        ClubOwner fc = ClubOwnerService.getById(id);
        if (fc == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fc, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/owner/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ClubOwner ClubOwner) {
        if (ClubOwnerService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            ClubOwner.setId(id);
            ClubOwnerService.saveOrUpdate(ClubOwner);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/owner/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = ClubOwnerService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
