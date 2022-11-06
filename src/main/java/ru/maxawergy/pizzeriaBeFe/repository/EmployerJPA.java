package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Employer;

@Repository
public interface EmployerJPA extends JpaRepository<Employer, Long> {
    public Employer findEmployerByLogin(String login);
}
