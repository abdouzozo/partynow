package com.pn.spring.partynow.Model;

import java.time.LocalDateTime;
import java.util.List;

public interface PartyService {
    Party createParty(String name, LocalDateTime date, String location);
    Party getPartyById(Long id);
    List<Party> getAllParties();
    void updateParty(Long id, String name, LocalDateTime date, String location, List<String> guests);
    void addGuestToParty(Long id, String guestName);
    void removeGuestFromParty(Long id, String guestName);
}