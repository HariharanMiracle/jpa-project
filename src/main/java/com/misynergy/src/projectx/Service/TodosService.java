package com.misynergy.src.projectx.Service;

import com.misynergy.src.projectx.Model.Todos;

import java.util.List;

public interface TodosService {
    Todos getTodosInfo(int id);
    Todos save(Todos todos);
    List<Todos> ListTodos();
    Todos delete(int id);
    Todos update(Todos todos);
    List<Todos> findTodosBetweenPriority(int min, int max);
    List<String> findTodosNameByPriority(int priority);
}
