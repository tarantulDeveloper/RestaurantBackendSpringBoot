package com.database.repo;

import com.database.model.Talas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalasRepo extends JpaRepository<Talas, Integer> {
}
