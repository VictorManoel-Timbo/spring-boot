package com.victortimbo.course.config;

import com.victortimbo.course.entities.Category;
import com.victortimbo.course.entities.Order;
import com.victortimbo.course.entities.User;
import com.victortimbo.course.entities.enums.OrderStatus;
import com.victortimbo.course.repositories.CategoryRepository;
import com.victortimbo.course.repositories.OrderRepository;
import com.victortimbo.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepositoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepositoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "9888", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "9777", "123456");

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
