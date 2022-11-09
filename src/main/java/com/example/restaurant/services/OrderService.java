package com.example.restaurant.services;

import com.example.restaurant.models.Order;
import com.example.restaurant.models.Product;
import com.example.restaurant.models.User;
import com.example.restaurant.repositories.OrderRepositories;
import com.example.restaurant.repositories.ProductRepository;
import com.example.restaurant.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositories orderRepository;
    private final ProductRepository productsRepository;
    List<Product> products=new ArrayList<>();
    public List<Product> listProductsatcart(User user)
    {
        List<Order> orders=  orderRepository.findByUser(user);
        for(Order order: orders){
            Product product=order.getProduct();
        products.add(product);
        }
        return products;
    }
    public void deletecount(Long id)
    {
        Order order= getOrderById(id);
        if(order.getCount()>1){
        order.setCount(order.getCount()-1);
        orderRepository.deleteById(id);
        orderRepository.save(order);
        }
        else
            orderRepository.deleteById(id);
    }
    public void addcount(Long id)
    {
        Order order= getOrderById(id);

            orderRepository.deleteById(id);
            order.setCount(order.getCount()+1);
            orderRepository.save(order);
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
