package com.misynergy.src.projectx.Repository;

import com.misynergy.src.projectx.Model.Todos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodosRepository extends CrudRepository<Todos, Long> {
    Todos findById(int id);

    @Query(value = "select * from todos where priority between ?1 and ?2", nativeQuery = true)
    List<Todos> findTodosBetweenPriority(int min, int max);

    @Query(value = "select name from todos where priority = ?1", nativeQuery = true)
    public List<String> findTodosNameByPriority(int priority);
}
