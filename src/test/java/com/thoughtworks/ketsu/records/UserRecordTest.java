package com.thoughtworks.ketsu.records;

import com.thoughtworks.ketsu.infrastructure.core.*;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class UserRecordTest {
    @Inject
    UserRepository userRepository;
    @Inject
    ProductRepository productRepository;

    @Test
    public void should_create_order_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Order order = user.createOrder(TestHelper.orderMap("kayla", product.getId()));
        assertThat(order.getName(), is("kayla"));
    }

    @Test
    public void should_list_orders_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Order order = user.createOrder(TestHelper.orderMap("kayla", product.getId()));
        List<Order> list = user.listOrder();
        assertThat(list.size(), is(1));
        assertThat(list.get(0).getName(), is("kayla"));
    }
}
