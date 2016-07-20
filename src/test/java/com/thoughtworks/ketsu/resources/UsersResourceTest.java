package com.thoughtworks.ketsu.resources;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UsersResourceTest extends ApiSupport {
    @Inject
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void should_return_201_when_create_user_with_specified_parameter(){
        Response post = post("users", TestHelper.userMap("John"));
        assertThat(post.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
        assertThat(Pattern.matches(".*?/users/[0-9-]*", post.getLocation().toASCIIString()), is(true));

    }

    @Test
    public void should_return_400_when_create_user_with_name_is_empty(){
        Response post = post("users", new HashMap<String, Object>());
        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
        final List<Map<String, Object>> errorInfo = post.readEntity(List.class);
        assertThat(errorInfo.size(), is(1));
    }

    @Test
    public void should_return_detail_when_find_user(){
        User user  = userRepository.createUser(TestHelper.userMap("John"));
        Response get = get("users/" + user.getId());
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
        final Map<String, Object> res = get.readEntity(Map.class);
        assertThat(res.get("uri"), is("/users/" + user.getId()));
    }

    @Test
    public void should_return_404_when_find_user_with_user_not_exist(){
        User user  = userRepository.createUser(TestHelper.userMap("John"));
        Response get = get("users/" + (user.getId()+1));
        assertThat(get.getStatus(), is(HttpStatus.NOT_FOUND_404.getStatusCode()));
    }

}
