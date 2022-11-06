package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Plan;

@Repository
public interface PlanJPA extends JpaRepository<Plan, Long> {
}
