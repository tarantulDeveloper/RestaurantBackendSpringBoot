package com.database.repo;

import com.database.model.Naryn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarynRepo extends JpaRepository<Naryn, Integer> {
}
