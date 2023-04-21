package com.pn.spring.partynow.Model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {
    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party createParty(String name, LocalDateTime date, String location) {
        Party party = new Party();
        party.setName(name);
        party.setDate(date);
        party.setLocation(location);
        return partyRepository.save(party);
    }



    @Override
    public Party getPartyById(Long id) {
        return partyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public void updateParty(Long id, String name, LocalDateTime date, String location, List<String> guests) {
        Party party = partyRepository.findById(id).orElse(null);
        if (party != null) {
            party.setName(name);
            party.setDate(date);
            party.setLocation(location);
            party.setGuests(guests);
            partyRepository.save(party);
        }
    }

    @Override
    public void addGuestToParty(Long id, String guestName) {
        Party party = partyRepository.findById(id).orElse(null);
        if (party != null) {
            List<String> guests = party.getGuests();
            if (guests == null) {
                guests = new ArrayList<>();
                party.setGuests(guests);
            }
            guests.add(guestName);
            partyRepository.save(party);
        }
    }

    @Override
    public void removeGuestFromParty(Long id, String guestName) {
        Party party = partyRepository.findById(id).orElse(null);
        if (party != null) {
            List<String> guests = party.getGuests();
            if (guests != null) {
                guests.remove(guestName);
                partyRepository.save(party);
            }
        }
    }
}
