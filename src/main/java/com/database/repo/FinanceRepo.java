package com.database.repo;

import com.database.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FinanceRepo extends JpaRepository<Finance, Integer> {

    @Modifying()
    @Query(value = "UPDATE finance SET marketing=marketing+?1", nativeQuery = true)
    @Transactional
    void addMarketing(Integer money);

    @Modifying()
    @Query(value = "UPDATE finance SET equipment=equipment+?1", nativeQuery = true)
    @Transactional
    void addEquipment(Integer money);

    @Modifying()
    @Query(value = "UPDATE finance SET salary=salary+?1", nativeQuery = true)
    @Transactional
    void addSal(Integer money);


    @Modifying()
    @Query(value="UPDATE finance SET marketing=marketing-?1", nativeQuery = true)
    @Transactional
    void minusMarketing(Integer money);

    @Modifying()
    @Query(value="UPDATE finance SET equipment=equipment-?1", nativeQuery = true)
    @Transactional
    void minusEquipment(Integer money);

    @Modifying()
    @Query(value="UPDATE finance SET salary=salary-?1", nativeQuery = true)
    @Transactional
    void minusSalary(Integer money);

    @Query(value = "SELECT marketing FROM finance", nativeQuery = true)
    Integer selectMarketing();

    @Query(value = "SELECT equipment FROM finance", nativeQuery = true)
    Integer selectEquipment();

    @Query(value = "SELECT salary FROM finance", nativeQuery = true)
    Integer selectSalary();

    @Query(value = "SELECT SUM(equipment + marketing + salary) FROM finance", nativeQuery = true)
    Integer overallSum();

}
