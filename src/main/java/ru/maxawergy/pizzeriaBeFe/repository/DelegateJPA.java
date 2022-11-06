package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Delegate;

@Repository
public interface DelegateJPA extends JpaRepository<Delegate, Long> {
}
