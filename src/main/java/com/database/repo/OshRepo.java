package com.database.repo;

import com.database.model.Osh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OshRepo extends JpaRepository<Osh, Integer> {
}
