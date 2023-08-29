package com.example.haemo.haemo.Repository.Acceptation;

import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcceptationRepository extends JpaRepository<Acceptation, Long> {
    List<Acceptation> findAllByuId(Long uId);
    Boolean existsBypId(Long pId);
}