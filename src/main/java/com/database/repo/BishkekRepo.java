package com.database.repo;

import com.database.model.Bishkek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BishkekRepo extends JpaRepository<Bishkek, Integer> {
}
