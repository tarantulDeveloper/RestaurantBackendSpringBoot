package com.database.controllers;

import com.database.ResourceNotFoundException;
import com.database.model.MarketingExpenses;
import com.database.repo.MarketExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketExpController {
    @Autowired
    private MarketExpenseRepo marketExpenseRepo;

    @PutMapping("market/expenses/change")
    public void updateExpenses(@RequestBody MarketingExpenses marketingExpenses)
        throws ResourceNotFoundException {
        MarketingExpenses marketingExpenses1 = marketExpenseRepo.findById(1).orElseThrow(
                () -> new ResourceNotFoundException("Can't find data")
        );
        System.out.println(marketingExpenses);
        marketingExpenses1.setFacebook(marketingExpenses.getFacebook());
        marketingExpenses1.setInstagram(marketingExpenses.getInstagram());
        marketingExpenses1.setLalafo(marketingExpenses.getLalafo());
        marketExpenseRepo.save(marketingExpenses1);
    }

    @GetMapping("/market/expenses/{id}")
    public MarketingExpenses getExpense(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException{
        return marketExpenseRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("NOt found")
        );

    }

}
