package com.example.haemo.haemo.Repository.Acceptation;

import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcceptationRepository extends JpaRepository<Acceptation, Long> {
    Acceptation findByUId(Long uId);
}