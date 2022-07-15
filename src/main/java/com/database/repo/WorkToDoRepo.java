package com.database.repo;

import com.database.model.WorkToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WorkToDoRepo extends JpaRepository<WorkToDo, Integer> {
    @Modifying()
    @Query(value = "DELETE FROM work_to_do WHERE emp_id = ?1 ",nativeQuery = true)
    @Transactional
    void deleteALlById( String userName);

    @Modifying()
    @Query(value = "DELETE FROM work_to_do WHERE id=?1 AND emp_id=?2", nativeQuery = true)
    @Transactional
    void deleteWorkOfWorker( Integer id, String userName);

    @Query(value = "SELECT * FROM work_to_do WHERE emp_id = ?1", nativeQuery = true)
    public List<WorkToDo> findAllByWorker(String username);

    @Modifying()
    @Query(value = "DELETE FROM work_to_do  WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteWork(Integer id);

    @Modifying()
    @Query(value = "INSERT INTO bishkek(location) VALUES(?1)",nativeQuery = true)
    @Transactional
    void insertInto(String locationName);
}
