package com.pn.spring.partynow.Controller;

import com.pn.spring.partynow.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @PostMapping("/")
    public ResponseEntity<Party> createParty(@RequestBody Party party) {
        Party createdParty = partyService.createParty(party.getName(), party.getDate(), party.getLocation());
        return new ResponseEntity<>(createdParty, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable Long id) {
        Party party = partyService.getPartyById(id);
        if (party != null) {
            return new ResponseEntity<>(party, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Party>> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParty(@PathVariable Long id, @RequestBody Party party) {
        partyService.updateParty(id, party.getName(), party.getDate(), party.getLocation(), party.getGuests());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/guests")
    public ResponseEntity<Void> addGuestToParty(@PathVariable Long id, @RequestBody String guestName) {
        partyService.addGuestToParty(id, guestName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/guests/{guestName}")
    public ResponseEntity<Void> removeGuestFromParty(@PathVariable Long id, @PathVariable String guestName) {
        partyService.removeGuestFromParty(id, guestName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
