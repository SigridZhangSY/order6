package com.thoughtworks.ketsu.records;

import com.thoughtworks.ketsu.infrastructure.core.*;
import com.thoughtworks.ketsu.infrastructure.repository.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class OrderRecordTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Test
    public void should_create_payment_for_order(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Order order = user.createOrder(TestHelper.orderMap("kayla", product.getId()));

        Payment payment = order.createPayment(TestHelper.paymentMap());
        assertThat(payment.getOrderId(), is(order.getId()));
    }

}
