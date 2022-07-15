package com.database.repo;

import com.database.model.Batken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatkenRepo extends JpaRepository<Batken, Integer> {
}
