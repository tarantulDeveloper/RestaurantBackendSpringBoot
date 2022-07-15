package com.database.repo;

import com.database.model.MarketingExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketExpenseRepo extends JpaRepository<MarketingExpenses, Integer> {

}
