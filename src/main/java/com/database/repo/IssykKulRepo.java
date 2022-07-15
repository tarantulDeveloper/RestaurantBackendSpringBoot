package com.database.repo;

import com.database.model.IssykKul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssykKulRepo extends JpaRepository<IssykKul, Integer> {
}
