package com.pn.spring.partynow.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

}