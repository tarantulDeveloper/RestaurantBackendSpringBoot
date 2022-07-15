package com.database.repo;

import com.database.model.JalalAbad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JalalAbadRepo extends JpaRepository<JalalAbad, Integer> {
}
