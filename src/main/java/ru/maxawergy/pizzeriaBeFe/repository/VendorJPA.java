package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Vendor;

@Repository
public interface VendorJPA extends JpaRepository<Vendor, Long> {
}
