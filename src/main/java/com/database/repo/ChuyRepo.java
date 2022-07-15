package com.database.repo;

import com.database.model.Chuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyRepo extends JpaRepository<Chuy, Integer> {
}
