package ru.maxawergy.pizzeriaBeFe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxawergy.pizzeriaBeFe.entity.Employer;
import ru.maxawergy.pizzeriaBeFe.repository.EmployerJPA;

import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerJPA employerJPA;

    public List<Employer> getAllEmployers(){
        return employerJPA.findAll();
    }

    public void saveEmployer(Employer employer){
        employerJPA.save(employer);
    }
}
