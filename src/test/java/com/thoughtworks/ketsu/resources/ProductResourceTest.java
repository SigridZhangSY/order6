package com.thoughtworks.ketsu.resources;

import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.ProductRepository;
import com.thoughtworks.ketsu.infrastructure.records.ProductRecord;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class ProductResourceTest extends ApiSupport {

    @Inject
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void should_return_201_when_create_product_with_specified_parameter(){
        Response post = post("products", TestHelper.productMap("apple"));
        assertThat(post.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
        assertThat(Pattern.matches(".*?/products/[0-9-]*", post.getLocation().toASCIIString()), is(true));
    }

    @Test
    public void should_return_400_when_create_product_with_name_is_empty(){
        Map<String, Object> map = TestHelper.productMap("apple");
        map.remove("name");
        Response post = post("products", map);
        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
        final List<Map<String, Object>> errorInfo = post.readEntity(List.class);
        assertThat(errorInfo.size(), is(1));

    }

    @Test
    public void should_return_detail_when_list_products(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Response get = get("products");
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
        final List<Map<String, Object>> list = get.readEntity(List.class);
        assertThat(list.size(), is(1));
        assertThat(list.get(0).get("uri"), is("/products/" + String.valueOf(product.getId())));
    }

    @Test
    public void should_return_detail_when_find_product(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Response get = get("products/" + String.valueOf(product.getId()));
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
        final Map<String, Object> res = get.readEntity(Map.class);
        assertThat(res.get("uri"), is("/products/" + product.getId()));
    }

    @Test
    public void should_return_404_when_product_not_exists(){
        Product product = productRepository.createProduct(TestHelper.productMap("apple"));
        Response get = get("products/" + String.valueOf(product.getId()+1));
        assertThat(get.getStatus(), is(HttpStatus.NOT_FOUND_404.getStatusCode()));
    }
}
