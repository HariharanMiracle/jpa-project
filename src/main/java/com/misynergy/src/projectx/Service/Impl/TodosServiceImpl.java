package com.misynergy.src.projectx.Service.Impl;

import com.misynergy.src.projectx.Model.Todos;
import com.misynergy.src.projectx.Repository.TodosRepository;
import com.misynergy.src.projectx.Service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodosRepository todosRepository;

    @Override
    public Todos getTodosInfo(int id) {
        return todosRepository.findById(id);
    }

    @Override
    public Todos save(Todos todos) {
        return todosRepository.save(todos);
    }

    @Override
    public List<Todos> ListTodos() {
        List<Todos> todos = new ArrayList<>();
        todosRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Todos delete(int id) {
        Todos todos = todosRepository.findById(id);
        todosRepository.delete(todos);
        return todos;
    }

    @Override
    public Todos update(Todos todos) {
        return todosRepository.save(todos);
    }

    @Override
    public List<Todos> findTodosBetweenPriority(int min, int max) {
        List<Todos> todos = todosRepository.findTodosBetweenPriority(min, max);
        return todos;
    }

    @Override
    public List<String> findTodosNameByPriority(int priority) {
        List<String> nameList = todosRepository.findTodosNameByPriority(priority);
        return nameList;
    }
}
