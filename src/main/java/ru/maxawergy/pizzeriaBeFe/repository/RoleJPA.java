package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Role;

@Repository
public interface RoleJPA extends JpaRepository<Role, Long> {
    public Role findRoleByName(String name);
}
