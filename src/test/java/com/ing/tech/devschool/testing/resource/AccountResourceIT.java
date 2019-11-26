package com.ing.tech.devschool.testing.resource;

import com.ing.tech.devschool.testing.api.resource.AccountResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountResource.class)
@ContextConfiguration(classes = {AccountResource.class})
public class AccountResourceIT {

    @Test
    public void shouldReturnOkWhenAccountIsPresent() {

    }

    @Test
    public void shouldReturnBadRequestWhenAccountIsNotPresent() {
        //TODO

    }

    @Test
    public void shouldDeleteAccountIfExists() {
        //TODO

    }

    @Test
    public void shouldNotDeleteAccountIfNotExists() {
        //TODO

    }

}
