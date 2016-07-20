package com.thoughtworks.ketsu.records;

import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.ProductRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
    @Inject
    ProductRepository productRepository;

    @Test
    public void should_save_and_find_product(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        assertThat(product.getName(), is("apple"));
    }

    @Test
    public void should_list_all_products(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        List<Product> list = productRepository.getAllProduct();
        assertThat(list.size(), is(1));
        assertThat(list.get(0).getName(), is("apple"));
    }

    @Test
    public void should_find_product_by_id(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Product product_res = productRepository.findProductById(product.getId()).get();
        assertThat(product_res.getId(), is(product.getId()));
    }
}
