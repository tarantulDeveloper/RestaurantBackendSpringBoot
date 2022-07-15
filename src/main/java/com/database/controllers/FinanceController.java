package com.database.controllers;

import com.database.ResourceNotFoundException;
import com.database.model.Finance;
import com.database.repo.FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FinanceController {
    @Autowired
    private FinanceRepo financeRepo;

    @PutMapping("/finance/marketing")
    public void addMarketing(@RequestBody Integer money){
        financeRepo.addMarketing(money);
    }

    @PutMapping("/finance/equipment")
    public void addEqu(@RequestBody Integer money){
        financeRepo.addEquipment(money);
    }

    @PutMapping("/finance/salary")
    public void addSala(@RequestBody Integer money){
        financeRepo.addSal(money);
    }

    @GetMapping("/finance/sum")
    public Integer getSum(){
        return financeRepo.overallSum();
    }

    @PutMapping ("/marketing/minus")
    void getMark(@RequestBody Integer minus) throws ResourceNotFoundException {
        System.out.println(minus);
        if(minus>financeRepo.selectMarketing()){
            throw new ResourceNotFoundException("NOT enough money");
        }
        financeRepo.minusMarketing(minus);


    }


    @PutMapping ("/equipment/minus")
    void getEquip(@RequestBody Integer minus) throws ResourceNotFoundException {
        System.out.println(minus);
        if(minus>financeRepo.selectEquipment()){
            throw new ResourceNotFoundException("NOT enough money");
        }
        financeRepo.minusEquipment(minus);


    }

    @PutMapping ("/salary/minus")
    void getSalar(@RequestBody Integer minus) throws ResourceNotFoundException {

        if(minus>financeRepo.selectSalary()){
            throw new ResourceNotFoundException("NOT enough money");
        }
        financeRepo.minusSalary(minus);


    }

    @GetMapping("/finance/all")
    public List<Finance> getAll(){
        return (List<Finance>) financeRepo.findAll();
    }

    @GetMapping("/finance/overall")
    public Integer getOverall(){
        return (Integer) financeRepo.overallSum();
    }
}
