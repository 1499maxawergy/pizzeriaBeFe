package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Customer;

import javax.transaction.Transactional;

@Repository
public interface CustomerJPA extends JpaRepository<Customer, Long> {
    public Customer findCustomerByPhoneNumber(String phone);

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_dishes SET dish_id = ?1, order_id = ?2, count = ?3 where dish_id = ?1 and order_id = ?2", nativeQuery = true)
    public void updateEnroll(Long DishId, Long OrderId, int newCount);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_dishes(dish_id, order_id, count) VALUE(?1,?2, 1)", nativeQuery = true)
    public void createEnroll(Long DishId, Long OrderId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM order_dishes where dish_id = ?1 and order_id = ?2", nativeQuery = true)
    public void deleteEnroll(Long DishId, Long OrderId);
}
