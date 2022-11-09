package com.example.restaurant;
import com.example.restaurant.Exception.NotFound;
import com.example.restaurant.models.Order;
import com.example.restaurant.models.Product;
import com.example.restaurant.models.User;
import com.example.restaurant.models.enums.Role;
import com.example.restaurant.repositories.UserRepository;
import com.example.restaurant.services.OrderService;
import com.example.restaurant.services.ProductService;
import com.example.restaurant.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeviceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private ProductService ProductService;
    @Autowired
    private OrderService OrderService;

    @Test
    public void getUserByEmail()
    {
        Assert.assertNotNull(userRepository.findByEmail("eugenealimake@gmail.com"));
    }

    @Test
    public void isAdmin()
    {
        User user = new User();
        user.getRoles().add(Role.ROLE_ADMIN);
        Assert.assertTrue(user.isAdmin());
    }

    @Test(expected = NotFound.class)
    public void getNotExistsProduct() throws NotFound {
        Product product=null;
            product =ProductService.getProductById(1123L);
        Assert.assertNull(product);
    }
    /*@Test(expected = NotFound.class)
    public void getNotExistsProduct2() throws NotFound {
        try {
            Product product = ProductService.getProductById(54646546L);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }*/
    @Test
    public void getOrderById() {
        Order order=OrderService.getOrderById(1123L);
        Assert.assertNull(order);
    }
}
