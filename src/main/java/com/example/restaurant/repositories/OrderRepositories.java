package com.example.restaurant.repositories;

import com.example.restaurant.models.Order;
import com.example.restaurant.models.Product;
import com.example.restaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepositories extends JpaRepository<Order, Long> {
    Order findByUserAndProduct(User user, Product Product);
    List<Order> findByUser(User user);
}
