package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingcartApplication;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingcartApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest
{
    @Autowired
    UserService userService;

    @org.junit.Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
    }

    @org.junit.Test
    public void findAll()
    {
        assertEquals(3, userService.findAll().size());
    }

    @org.junit.Test
    public void findUserById()
    {
        assertEquals("barnbarn", userService.findUserById(1).getUsername());
    }

    @org.junit.Test
    public void findByUsername()
    {
        assertEquals(3, userService.findByUsername("stumps").getUserid());
    }

    @org.junit.Test
    public void delete()
    {
    }
}